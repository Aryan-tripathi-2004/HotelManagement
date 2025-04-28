package com.example.roomservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReservationInputDto {
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
