package com.example.roomservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Builder
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numberOfChildren;
    private int numberOfAdults;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String roomNumber;
}
