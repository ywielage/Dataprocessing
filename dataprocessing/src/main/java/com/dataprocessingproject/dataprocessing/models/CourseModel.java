package com.dataprocessingproject.dataprocessing.models;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class CourseModel {
    private String id;
    private String difficulty;
    private String gameStyle;
    private String maker;
    private String title;
    private String thumbnail;
    private String image;
    private String creation;

    public CourseModel(String id, String difficulty, String gameStyle, String maker, String title, String thumbnail, String image, String creation) {
        this.id = id;
        this.difficulty = difficulty;
        this.gameStyle = gameStyle;
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

    public String getGameStyle() {
        return gameStyle;
    }

    public void setGameStyle(String gameStyle) {
        this.gameStyle = gameStyle;
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
