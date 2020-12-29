package ru.netology.entity;

import junit.framework.TestCase;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class AstronomyPictureOfTheDayTest extends TestCase {

    public void testGetImageUrl() {
        //given:
        AstronomyPictureOfTheDay apod = new AstronomyPictureOfTheDay("image", "image.jpg", "");

        //when
        String url = apod.getImageUrl();

        //then:
        assertThat(url, is(equalTo("image.jpg")));
    }

    public void testGetVideoImageUrl() {
        //given:
        AstronomyPictureOfTheDay apod = new AstronomyPictureOfTheDay("video", "", "video.jpg");

        //when
        String url = apod.getImageUrl();

        //then:
        assertThat(url, is(equalTo("video.jpg")));
    }

    public void testGetImageName() {
        //given:
        AstronomyPictureOfTheDay apod = new AstronomyPictureOfTheDay("image", "//test/test/img.jpg", "");

        //when
        String url = apod.getImageName();

        //then:
        assertThat(url, is(equalTo("img.jpg")));
    }
}