import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            List<DiscountCode> discountCodes =
                    DiscountCodeReader.readDiscountCodes();

            for (DiscountCode discountCode : discountCodes) {
                System.out.println(discountCode);
            }

            System.out.println(
                    "Anzahl gelesener Rabattcodes: " + discountCodes.size()
            );

        } catch (IOException e) {
            System.err.println(
                    "Fehler beim Einlesen der Rabattcodes: " + e.getMessage()
            );
        }
    }
}