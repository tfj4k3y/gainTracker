package com.example.gaintracker;

public class TreningObject {
    public TreningObject(String date, String dayOfWeek) {
        this.date = date;
        this.dayOfWeek = dayOfWeek;
    }

    private String date;

    public String getDate() {
        return date;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    private String dayOfWeek;
}
