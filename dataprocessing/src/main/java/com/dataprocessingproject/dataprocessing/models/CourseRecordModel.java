package com.dataprocessingproject.dataprocessing.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "records") // Tabel waar data van wordt opgehaald
public class CourseRecordModel { // Haalt data op en zet deze in dit model
    private String date;
    private String id;
    private String player;
    private String record;

    public CourseRecordModel(String date, String id, String player, String record) {
        this.date = date;
        this.id = id;
        this.player = player;
        this.record = record;
    }

    public CourseRecordModel(){

    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }
}
