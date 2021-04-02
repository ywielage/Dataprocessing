package com.dataprocessingproject.dataprocessing.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "players") // Tabel waar data van wordt opgehaald
public class PlayerModel { // Haalt data op en zet deze in dit model
    private String id;
    private String image;
    private String flag;
    private String name;

    public PlayerModel(String id, String image, String flag, String name) {
        this.id = id;
        this.image = image;
        this.flag = flag;
        this.name = name;
    }

    public PlayerModel(){

    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
