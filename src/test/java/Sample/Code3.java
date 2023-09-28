package Sample;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.IOException;

public class Code3 {
    public static void main(String[] args) {
        String apiUrl = "https://ayatana.xircular.io/content-manager/collection-types/api::testing.testing?page=1&pageSize=10&sort=name:ASC"; // Replace with your Strapi API URL
        String accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwiaWF0IjoxNjkxODUyNTM3LCJleHAiOjE2OTQ0NDQ1Mzd9.oYqnScS2tY0BEepHGjZX7s6EwTT1BOKLmyQ41C7CXvc"; // Replace with your Strapi access token
        String mediaFieldName = "media"; // Replace with the actual field name
        String filePath = "C:\\\\Users\\\\HI\\\\Downloads\\\\Group 2.png"; // Replace with the actual file path
        String contentTypeEndpoint = "/your-content-type-endpoint"; // Replace with the endpoint of your content type

        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost uploadFile = new HttpPost(apiUrl + contentTypeEndpoint);

            uploadFile.setHeader("Authorization", "Bearer " + accessToken);

            FileBody fileBody = new FileBody(new File(filePath));

            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addPart(mediaFieldName, fileBody);

            uploadFile.setEntity(builder.build());

            HttpResponse response = httpClient.execute(uploadFile);

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                System.out.println("Media uploaded successfully");
            } else {
                System.err.println("Media upload failed. Status Code: " + statusCode);
            }

            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

