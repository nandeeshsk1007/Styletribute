package Sample;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Code {
    public static void main(String[] args) {
        try {
            // Strapi API URL
            String apiUrl = "https://ayatana.xircular.io/content-manager/collection-types/api::gallery.gallery?page=1&pageSize=10&sort=id:ASC";
            
            // Replace with your actual authentication token
            String authToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwiaWF0IjoxNjkxODUyNTM3LCJleHAiOjE2OTQ0NDQ1Mzd9.oYqnScS2tY0BEepHGjZX7s6EwTT1BOKLmyQ41C7CXvc";
            
            // JSON data to upload
            String jsonData = "{\"media_data\": \"https://docs.strapi.io/img/assets/content-type-builder/fields-selection.png\", \"ai_meta_data\": \"Sample Article\"}";

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method and headers
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + authToken);
            connection.setDoOutput(true);

            // Write data to the request
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonData.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Get response
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Handle response if needed
            // ...

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
