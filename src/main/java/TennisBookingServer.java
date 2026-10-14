import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class TennisBookingServer {
    private static final int PORT = 8080;
    private static final String COURTS_FILE = "courts.json";
    private static final String BOOKINGS_FILE = "bookings.json";

    public static void main(String[] args) throws IOException {
        initializeDataFiles();
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);

        // API Endpoints
        server.createContext("/api/courts", new CourtsHandler());
        server.createContext("/api/bookings", new BookingsHandler());

        // Static File Serving (HTML/CSS/JS)
        server.createContext("/", new StaticFileHandler());

        server.setExecutor(null);
        System.out.println("🎾 Tennis Court Server läuft auf: http://localhost:" + PORT);
        System.out.println("Öffne http://localhost:8080 im Browser!");
        server.start();
    }

    private static void initializeDataFiles() throws IOException {
        if (!Files.exists(Paths.get(COURTS_FILE))) {
            String initialCourts = "[\n" +
                    "  {\"id\": 1, \"name\": \"Court 1 - Center Court\", \"surface\": \"Clay (Sand)\", \"indoor\": false, \"pricePerHour\": 35.0, \"lights\": true},\n" +
                    "  {\"id\": 2, \"name\": \"Court 2 - Grandstand\", \"surface\": \"Clay (Sand)\", \"indoor\": false, \"pricePerHour\": 30.0, \"lights\": true},\n" +
                    "  {\"id\": 3, \"name\": \"Court 3 - All-Weather\", \"surface\": \"Hard Court\", \"indoor\": false, \"pricePerHour\": 25.0, \"lights\": false},\n" +
                    "  {\"id\": 4, \"name\": \"Court 4 - Indoor Arena\", \"surface\": \"Carpet / Indoor\", \"indoor\": true, \"pricePerHour\": 42.0, \"lights\": true}\n" +
                    "]";
            Files.write(Paths.get(COURTS_FILE), initialCourts.getBytes(StandardCharsets.UTF_8));
        }

        if (!Files.exists(Paths.get(BOOKINGS_FILE))) {
            String initialBookings = "[\n" +
                    "  {\"id\": \"b-101\", \"courtId\": 1, \"date\": \"2025-05-10\", \"startTime\": \"10:00\", \"endTime\": \"11:00\", \"playerName\": \"Max Mustermann\", \"email\": \"max@example.com\"}\n" +
                    "]";
            Files.write(Paths.get(BOOKINGS_FILE), initialBookings.getBytes(StandardCharsets.UTF_8));
        }
    }

    static class CourtsHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            addCorsHeaders(exchange);
            if ("OPTIONS".equalsIgnoreCase(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(204, -1);
                return;
            }
            if ("GET".equalsIgnoreCase(exchange.getRequestMethod())) {
                byte[] response = Files.readAllBytes(Paths.get(COURTS_FILE));
                exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
                exchange.sendResponseHeaders(200, response.length);
                OutputStream os = exchange.getResponseBody();
                os.write(response);
                os.close();
            } else {
                exchange.sendResponseHeaders(405, -1);
            }
        }
    }

    static class BookingsHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            addCorsHeaders(exchange);
            if ("OPTIONS".equalsIgnoreCase(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(204, -1);
                return;
            }
            if ("GET".equalsIgnoreCase(exchange.getRequestMethod())) {
                byte[] response = Files.readAllBytes(Paths.get(BOOKINGS_FILE));
                exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
                exchange.sendResponseHeaders(200, response.length);
                OutputStream os = exchange.getResponseBody();
                os.write(response);
                os.close();
            } else if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {
                InputStream is = exchange.getRequestBody();
                String body = new String(is.readAllBytes(), StandardCharsets.UTF_8);

                // Simple JSON append
                String current = new String(Files.readAllBytes(Paths.get(BOOKINGS_FILE)), StandardCharsets.UTF_8).trim();
                if (current.endsWith("]")) {
                    current = current.substring(0, current.length() - 1).trim();
                    if (current.length() > 1 && !current.endsWith("[")) {
                        current += ",\n  " + body + "\n]";
                    } else {
                        current += "\n  " + body + "\n]";
                    }
                } else {
                    current = "[" + body + "]";
                }
                Files.write(Paths.get(BOOKINGS_FILE), current.getBytes(StandardCharsets.UTF_8));

                byte[] respBytes = "{\"status\": \"success\", \"message\": \"Buchung erfolgreich gespeichert!\"}".getBytes(StandardCharsets.UTF_8);
                exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
                exchange.sendResponseHeaders(201, respBytes.length);
                OutputStream os = exchange.getResponseBody();
                os.write(respBytes);
                os.close();
            } else {
                exchange.sendResponseHeaders(405, -1);
            }
        }
    }

    static class StaticFileHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String path = exchange.getRequestURI().getPath();
            if (path.equals("/") || path.isEmpty()) {
                path = "/index.html";
            }
            File file = new File("." + path);
            if (!file.exists() || file.isDirectory()) {
                byte[] notFound = "<h1>404 Not Found</h1>".getBytes(StandardCharsets.UTF_8);
                exchange.sendResponseHeaders(404, notFound.length);
                exchange.getResponseBody().write(notFound);
                exchange.getResponseBody().close();
                return;
            }

            String contentType = "text/html; charset=UTF-8";
            if (path.endsWith(".css")) contentType = "text/css";
            if (path.endsWith(".js")) contentType = "application/javascript";
            if (path.endsWith(".json")) contentType = "application/json";

            byte[] bytes = Files.readAllBytes(file.toPath());
            exchange.getResponseHeaders().set("Content-Type", contentType);
            exchange.sendResponseHeaders(200, bytes.length);
            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();
        }
    }

    private static void addCorsHeaders(HttpExchange exchange) {
        exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "Content-Type, Authorization");
    }
}
