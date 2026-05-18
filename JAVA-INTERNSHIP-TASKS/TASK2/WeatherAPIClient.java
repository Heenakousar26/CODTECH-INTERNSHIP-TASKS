import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

// Main class
public class WeatherAPIClient {

    // Main method
    public static void main(String[] args) {

        try {

            // =========================================
            // CITY NAME
            // =========================================

            String city = "Hyderabad";

            // =========================================
            // ENTER YOUR API KEY
            // =========================================

            String apiKey = "715aba80e42b2477a1aaad12ece90a4d";

            // =========================================
            // API URL
            // =========================================

            String urlString =
                    "https://api.openweathermap.org/data/2.5/weather?q="
                            + city
                            + "&appid="
                            + apiKey
                            + "&units=metric";

            // Create URL object
           URI uri = new URI(urlString);
URL url = uri.toURL();

            // Open HTTP connection
            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod("GET");

            // =========================================
            // GET RESPONSE CODE
            // =========================================

            int responseCode = connection.getResponseCode();

            System.out.println("HTTP Response Code: "
                    + responseCode);

            // =========================================
            // SUCCESS CHECK
            // =========================================

            if (responseCode == 200) {

                // Read API response
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        connection.getInputStream()));

                String inputLine;

                StringBuilder response =
                        new StringBuilder();

                // Read response line by line
                while ((inputLine = reader.readLine())
                        != null) {

                    response.append(inputLine);
                }

                // Close reader
                reader.close();

                // =========================================
                // DISPLAY RESPONSE
                // =========================================

                System.out.println(
                        "\nWeather Data for "
                                + city + ":\n");

                System.out.println(response.toString());

            } else {

                System.out.println(
                        "Failed to fetch weather data.");
            }

            // Disconnect connection
            connection.disconnect();

        } catch (Exception e) {

            // Error handling
            System.out.println(
                    "An error occurred:");

            System.out.println(e.getMessage());
        }
    }
}