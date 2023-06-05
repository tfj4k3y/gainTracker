package com.example.gaintracker.objects;

public class TreningObject {
    private long id;
    private String date;
    private String dayOfWeek;

    public TreningObject(long id, String date, String dayOfWeek) {
        this.date = date;
        this.dayOfWeek = dayOfWeek;
        this.id= id;
    }

    public String getDate() {
        return date;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public long getId() {
        return id;
    }
}
