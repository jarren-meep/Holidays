package com.myapplicationdev.android.holidays;

public class Holiday {
    private String Day;
    private String Date;
    private int Img;
    public Holiday(String Day, String Date, int Img) {
        this.Day = Day;
        this.Date = Date;
        this.Img = Img;
    }
    public String getDay() {
        return Day;
    }
    public String getDate() {
        return Date;
    }
    public int getImg() {
        return Img;
    }
}
