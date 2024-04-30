package be.intecbrussel.appointment.jpa.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @Column(name = "id")
    private LocalDateTime id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;

    @Column(name = "day")
    private int day;
    @Column(name = "month")
    private int month;
    @Column(name = "year")
    private int year;
    @Column(name = "hour")
    private int hour;
    @Column(name = "minute")
    private int minute;


    public Appointment() {
    }

    public Appointment(String title, String description, int day, int month, int year, int hour, int minute) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy__HH_mm");
        this.id = LocalDateTime.parse(String.format("%02d_%02d_%04d__%02d_%02d", day, month, year, hour, minute), formatter);
        this.title = title;
        this.description = description;
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
    }

    public LocalDateTime getId() {
        return id;
    }

    public void setId(LocalDateTime id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", day='" + day + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                ", hour='" + hour + '\'' +
                ", minute='" + minute + '\'' +
                '}';
    }
}
