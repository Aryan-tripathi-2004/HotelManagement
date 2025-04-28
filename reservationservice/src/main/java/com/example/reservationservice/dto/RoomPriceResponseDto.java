package com.example.reservationservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomPriceResponseDto {
    private double basicPrice;
    private double firstNightPrice;
}
