package com.dataprocessingproject.dataprocessing.models;

import javax.persistence.*;

@Entity
@Table(name = "courses") // Tabel waar data van wordt opgehaald
public class CourseModel { // Haalt data op en zet deze in dit model
    private String id;
    private String difficulty;
    private String gamestyle;
    private String maker;
    private String title;
    private String thumbnail;
    private String image;
    private String creation;

    public CourseModel(String id, String difficulty, String gamestyle, String maker, String title, String thumbnail, String image, String creation) {
        this.id = id;
        this.difficulty = difficulty;
        this.gamestyle = gamestyle;
        this.maker = maker;
        this.title = title;
        this.thumbnail = thumbnail;
        this.image = image;
        this.creation = creation;
    }

    public CourseModel() {

    }

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getGamestyle() {
        return gamestyle;
    }

    public void setGamestyle(String gamestyle) {
        this.gamestyle = gamestyle;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreation() {
        return creation;
    }

    public void setCreation(String creation) {
        this.creation = creation;
    }

}
