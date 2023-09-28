package Sample;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;

public class Code1 {
    public static void main(String[] args) {
        try {
            // Strapi Media API URL
            String apiUrl = "https://ayatana.xircular.io/content-manager/collection-types/api::testing.testing?page=1&pageSize=10&sort=name:ASC";

            // Replace with your actual authentication token
            String authToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwiaWF0IjoxNjkxODUyNTM3LCJleHAiOjE2OTQ0NDQ1Mzd9.oYqnScS2tY0BEepHGjZX7s6EwTT1BOKLmyQ41C7CXvc";

            // Media file to upload
            File mediaFile = new File("https://ayatana.xircular.io/uploads/Frame_13783_1591172255.png");

            // Create HTTP client
            try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                HttpPost httpPost = new HttpPost(apiUrl);

                // Set headers
                httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + authToken);

                // Create multipart entity builder
                MultipartEntityBuilder builder = MultipartEntityBuilder.create();
                builder.addBinaryBody("media", mediaFile);
                HttpEntity multipartEntity = builder.build();

                // Set multipart entity as request entity
                httpPost.setEntity(multipartEntity);

                // Execute the request
                HttpResponse response = httpClient.execute(httpPost);
                HttpEntity responseEntity = response.getEntity();

                // Print response
                if (responseEntity != null) {
                    String responseString = EntityUtils.toString(responseEntity);
                    System.out.println("Response: " + responseString);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
