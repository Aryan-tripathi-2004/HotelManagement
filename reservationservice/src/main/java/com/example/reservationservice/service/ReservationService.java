package com.example.reservationservice.service;

import com.example.reservationservice.dto.ReservationRequestDto;
import com.example.reservationservice.dto.ReservationResponseDto;

import java.util.List;

public interface ReservationService {
    ReservationResponseDto createReservation(ReservationRequestDto requestDto, String token);
    ReservationResponseDto getReservationById(Long id, String token);
    List<ReservationResponseDto> getAllReservations(String token);
    void deleteReservation(Long id, String token);
    ReservationResponseDto updateReservation(Long id, ReservationRequestDto requestDto, String token);
}
