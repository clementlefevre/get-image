package com.akquinet.model.Images;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by CLE on 02.07.17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {


    private String id;
    private String artist;
    private String caption;
    private MaxDimensions maxDimensions;
    private String title;
    private String date;
    private List<DisplaySize> displaySize;

    public Image() {
    }

    @JsonProperty("display_sizes")
    public List<DisplaySize> getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(List<DisplaySize> displaySize) {
        this.displaySize = displaySize;
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }


    @JsonProperty("date_camera_shot")
    public String getDate() {
        return date;
    }

    @JsonProperty("max_dimensions")
    public MaxDimensions getMaxDimensions() {
        return maxDimensions;
    }


    public void setMaxDimensions(MaxDimensions maxDimensions) {
        this.maxDimensions = maxDimensions;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }


    public void setDate(String date) {
        this.date = date;
    }


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Image{" +
                "caption='" + this.caption + '\'' +
                ", maxDimensions=" + this.maxDimensions + '\'' +
                ", artist=" + this.artist + '\'' +
                ", date=" + this.date +
                '}';
    }
}
