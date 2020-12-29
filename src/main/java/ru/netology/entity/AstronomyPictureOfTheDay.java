package ru.netology.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AstronomyPictureOfTheDay {
    private final String date;
    private final String explanation;
    private final String media_type;
    private final String service_version;
    private final String title;
    private final String url;
    private final String hdurl;
    private final String thumbnail_url;
    private final String copyright;

    public AstronomyPictureOfTheDay(
            @JsonProperty("date") String date,
            @JsonProperty("explanation") String explanation,
            @JsonProperty("media_type") String media_type,
            @JsonProperty("service_version") String service_version,
            @JsonProperty("title") String title,
            @JsonProperty("url") String url,
            @JsonProperty("hdurl") String hdurl,
            @JsonProperty("thumbnail_url") String thumbnail_url,
            @JsonProperty("copyright") String copyright) {
        this.date = date;
        this.explanation = explanation;
        this.media_type = media_type;
        this.service_version = service_version;
        this.title = title;
        this.url = url;
        this.hdurl = hdurl;
        this.thumbnail_url = thumbnail_url;
        this.copyright = copyright;
    }

    public AstronomyPictureOfTheDay (String media_type, String url, String thumbnail_url) {
        this.media_type = media_type;
        this.url = url;
        this.thumbnail_url = thumbnail_url;
        this.date = "";
        this.explanation = "";
        this.service_version = "";
        this.title = "";
        this.hdurl = "";
        this.copyright = "";
    }

    @Override
    public String toString() {
        return "APOD{" +
                "date='" + date + '\'' +
                ", explanation='" + explanation + '\'' +
                ", media_type='" + media_type + '\'' +
                ", service_version='" + service_version + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", hdurl='" + hdurl + '\'' +
                '}';
    }

    public String getImageUrl() {
        switch (media_type) {
            case "image" : {
                return url;
            }
            case "video" : {
                return thumbnail_url;
            }
            default: {
                throw new RuntimeException("Can't get image url.");
            }
        }
    }

    public String getImageName() {
        String path = getImageUrl();
        return path.substring(path.lastIndexOf("/") + 1);
    }
}
