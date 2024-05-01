package com.example.homepage;

public class Model {
    String title, date, time, id;

    public Model() {
    }

    public Model(String id, String title, String date, String time) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public String getID(){return id;}

    public void setID(){this.id = id;}

    public void setTime(String time) {
        this.time = time;
    }
}
