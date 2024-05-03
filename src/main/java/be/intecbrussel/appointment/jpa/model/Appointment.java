package be.intecbrussel.appointment.jpa.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString

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

}
