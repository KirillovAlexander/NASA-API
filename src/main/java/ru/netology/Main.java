package ru.netology;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import ru.netology.entity.AstronomyPictureOfTheDay;
import ru.netology.saving.picture.SavingPictureImpl;
import ru.netology.saving.picture.SavingPictureService;

import java.io.IOException;

public class Main {

    public static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();

        HttpGet request = new HttpGet("https://api.nasa.gov/planetary/apod?api_key=wlLnDJ1W5Och9S6iQoF5FSiPj7Law0JMM5aezqbJ&thumbs=true"); //video
        //HttpGet request = new HttpGet("https://api.nasa.gov/planetary/apod?api_key=wlLnDJ1W5Och9S6iQoF5FSiPj7Law0JMM5aezqbJ&date=2020-12-28&thumbs=true"); //image
        CloseableHttpResponse response = httpClient.execute(request);

        AstronomyPictureOfTheDay apod = mapper.readValue(response.getEntity().getContent(), new TypeReference<AstronomyPictureOfTheDay>() {});
        SavingPictureService savingPictureService = new SavingPictureImpl();
        savingPictureService.savePicture(apod.getImageUrl(), "", apod.getImageName());
    }
}
