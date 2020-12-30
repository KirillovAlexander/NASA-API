package ru.netology.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AstronomyPictureOfTheDay {
    private final String date;
    private final String explanation;
    private final String mediaType;
    private final String serviceVersion;
    private final String title;
    private final String url;
    private final String hdUrl;
    private final String thumbnailUrl;
    private final String copyright;

    public AstronomyPictureOfTheDay(
            @JsonProperty("date") String date,
            @JsonProperty("explanation") String explanation,
            @JsonProperty("media_type") String mediaType,
            @JsonProperty("service_version") String serviceVersion,
            @JsonProperty("title") String title,
            @JsonProperty("url") String url,
            @JsonProperty("hdurl") String hdUrl,
            @JsonProperty("thumbnail_url") String thumbnailUrl,
            @JsonProperty("copyright") String copyright) {
        this.date = date;
        this.explanation = explanation;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
        this.hdUrl = hdUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.copyright = copyright;
    }

    public AstronomyPictureOfTheDay (String mediaType, String url, String thumbnailUrl) {
        this.mediaType = mediaType;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
        this.date = "";
        this.explanation = "";
        this.serviceVersion = "";
        this.title = "";
        this.hdUrl = "";
        this.copyright = "";
    }

    @Override
    public String toString() {
        return "APOD{" +
                "date='" + date + '\'' +
                ", explanation='" + explanation + '\'' +
                ", media_type='" + mediaType + '\'' +
                ", service_version='" + serviceVersion + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", hdurl='" + hdUrl + '\'' +
                '}';
    }

    public String getImageUrl() {
        switch (mediaType) {
            case "image" : {
                return url;
            }
            case "video" : {
                return thumbnailUrl;
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
