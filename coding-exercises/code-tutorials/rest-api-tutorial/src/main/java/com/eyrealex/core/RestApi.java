package main.java.com.eyrealex.core; // Importing the necessary packages and declaring the package name.

import com.google.gson.Gson; // Importing the Gson library for JSON processing.
import main.java.com.eyrealex.constants.ApiConstant; // Importing the constant class for API keys.
import main.java.com.eyrealex.util.Transcript; // Importing the Transcript class for creating transcript objects.

import java.net.URI; // Importing URI class for handling URIs.
import java.net.http.HttpClient; // Importing HttpClient class for making HTTP requests.
import java.net.http.HttpRequest; // Importing HttpRequest class for constructing HTTP requests.
import java.net.http.HttpResponse; // Importing HttpResponse class for handling HTTP responses.

public class RestApi { // Declaring the RestApi class.

    public static void main(String[] args) throws Exception { // Main method.

        Transcript transcript = new Transcript(); // Creating a new Transcript object.

        // Setting the audio URL for the transcript object.
        transcript.setAudio_url("https://github.com/AssemblyAI-Examples/audio-examples/raw/main/20230607_me_canadian_wildfires.mp3");

        Gson gson = new Gson(); // Creating a new Gson object for JSON serialization and deserialization.

        // Serializing the transcript object to JSON string.
        String jsonRequest = gson.toJson(transcript);

        // Building a POST request for submitting the transcript to the API.
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.assemblyai.com/v2/transcript"))
                .header("Authorization", ApiConstant.API_KEY)
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest)).build();

        HttpClient httpClient = HttpClient.newHttpClient(); // Creating a new HTTP client.

        // Sending the POST request to the API and getting the response.
        HttpResponse<String> postRespose = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());

        // Printing the body of the POST response.
        System.out.println(postRespose.body());

        // Deserializing the POST response body to Transcript object to get the transcript ID.
        transcript = gson.fromJson(postRespose.body(), Transcript.class);
        transcript.getId(); // Retrieving the transcript ID.

        // Building a GET request for retrieving the transcript status using the transcript ID.
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.assemblyai.com/v2/transcript/" + transcript.getId()))
                .header("Authorization", ApiConstant.API_KEY)
                .build();

        while (true) { // Loop for checking the status of the transcript.

            // Sending the GET request to the API and getting the response.
            HttpResponse<String> getRespose = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            transcript = gson.fromJson(getRespose.body(), Transcript.class); // Deserializing the GET response body to Transcript object.
            System.out.println(transcript.getStatus()); // Printing the status of the transcript.

            // Checking if the transcript status is "completed" or "error" to break the loop.
            if ("completed".equals(transcript.getStatus()) || "error".equals(transcript.getStatus())) {
                break;
            }
            Thread.sleep(1000); // Sleeping for 1 second before sending the next GET request.
        }

        // Printing a message indicating transaction completion.
        System.out.println("Transaction completed");
        // Printing the text content of the transcript.
        System.out.println(transcript.getText());
    }
}
