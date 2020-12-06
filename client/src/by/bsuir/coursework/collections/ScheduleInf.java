package by.bsuir.coursework.collections;

import java.sql.Date;
import java.sql.Time;

public class ScheduleInf {
    private Integer idschedule;
    private Date sessionDate;
    private Time sessionTime;
    private String movieTitle;
    private String genre;
    private String format;
    private String age;
    private Double price;

    public ScheduleInf(Integer idschedule, Date sessionDate, Time sessionTime, String movieTitle, String genre, String format, String age, Double price) {
        this.idschedule = idschedule;
        this.sessionDate = sessionDate;
        this.sessionTime = sessionTime;
        this.movieTitle = movieTitle;
        this.genre = genre;
        this.format = format;
        this.age = age;
        this.price = price;
    }

    public Integer getIdschedule() {
        return idschedule;
    }

    public void setIdschedule(Integer idschedule) {
        this.idschedule = idschedule;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    public Time getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(Time sessionTime) {
        this.sessionTime = sessionTime;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}



