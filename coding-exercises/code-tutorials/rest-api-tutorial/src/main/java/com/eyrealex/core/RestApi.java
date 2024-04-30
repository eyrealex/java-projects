package main.java.com.eyrealex.core;

import com.google.gson.Gson;
import main.java.com.eyrealex.constants.ApiConstant;
import main.java.com.eyrealex.util.Transcript;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestApi {
    public static void main(String[] args) throws Exception {

        Transcript transcript = new Transcript();
        transcript.setAudio_url("https://github.com/AssemblyAI-Examples/audio-examples/raw/main/20230607_me_canadian_wildfires.mp3");

        Gson gson = new Gson();
        String jsonRequest = gson.toJson(transcript);

        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.assemblyai.com/v2/transcript"))
                .header("Authorization", ApiConstant.API_KEY)
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest)).build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> postRespose = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println(postRespose.body());

    }
}

