package org.example.coffeewithtelegram;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tbl_booked")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booked {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String phoneNumber;
    private String email;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate date;

    @DateTimeFormat(pattern = "h:mm a")
    private LocalTime time;
    private int person;
}