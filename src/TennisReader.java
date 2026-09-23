
import com.fasterxml.jackson.databind;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TennisReader {

    public static TennisData readTennisData() throws IOException {
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

        // Required for OffsetDateTime values in Tennis.json
        com.fasterxml.jackson.databind.ObjectMapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());

        Path filePath = Path.of("data", "Tennis.json");

        if (!Files.exists(filePath)) {
            throw new IOException(
                    "The file was not found: "
                            + filePath.toAbsolutePath()
            );
        }

        return objectMapper.readValue(
                filePath.toFile(),
                TennisData.class
        );
    }
}