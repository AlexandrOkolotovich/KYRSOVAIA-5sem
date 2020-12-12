package by.bsuir.coursework.database;

import by.bsuir.coursework.Copyable;

import java.sql.Date;
import java.sql.Time;


public class Schedule implements Copyable {
    private int idschedule;
    private int movie_idmovie;
    private Date sessionDate;
    private Time sessionTime;
    private String format;
    private double price;

    public Schedule(int idschedule, int movie_idmovie, Date sessionDate, Time sessionTime, String format, double price) {
        this.idschedule = idschedule;
        this.movie_idmovie = movie_idmovie;
        this.sessionDate = sessionDate;
        this.sessionTime = sessionTime;
        this.format = format;
        this.price = price;
    }

    public Schedule(int idschedule, Date sessionDate, double price) {
        this.idschedule = idschedule;
        this.sessionDate = sessionDate;
        this.price = price;
    }

    public Schedule(int movie_idmovie, Date sessionDate, Time sessionTime, String format, double price) {
        this.movie_idmovie = movie_idmovie;
        this.sessionDate = sessionDate;
        this.sessionTime = sessionTime;
        this.format = format;
        this.price = price;
    }

    public Schedule() {
    }

    public int getIdschedule() {
        return idschedule;
    }

    public void setIdschedule(int idschedule) {
        this.idschedule = idschedule;
    }

    public int getMovie_idmovie() {
        return movie_idmovie;
    }

    public void setMovie_idmovie(int movie_idmovie) {
        this.movie_idmovie = movie_idmovie;
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

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public Copyable copy() {
        return new Schedule(idschedule, sessionDate, price);
    }
}
