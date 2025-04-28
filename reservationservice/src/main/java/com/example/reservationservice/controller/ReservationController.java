package com.example.reservationservice.controller;

import com.example.reservationservice.dto.ReservationRequestDto;
import com.example.reservationservice.dto.ReservationResponseDto;
import com.example.reservationservice.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationResponseDto> createReservation(@RequestHeader("Authorization") String token,
                                                                    @RequestBody ReservationRequestDto requestDto) {
        return ResponseEntity.ok(reservationService.createReservation(requestDto, token));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationResponseDto> getReservationById(@RequestHeader("Authorization") String token,
                                                                     @PathVariable Long id) {
        return ResponseEntity.ok(reservationService.getReservationById(id, token));
    }

    @GetMapping
    public ResponseEntity<List<ReservationResponseDto>> getAllReservations(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(reservationService.getAllReservations(token));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationResponseDto> updateReservation(@RequestHeader("Authorization") String token,
                                                                    @PathVariable Long id,
                                                                    @RequestBody ReservationRequestDto requestDto) {
        return ResponseEntity.ok(reservationService.updateReservation(id, requestDto, token));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReservation(@RequestHeader("Authorization") String token,
                                                    @PathVariable Long id) {
        reservationService.deleteReservation(id, token);
        return ResponseEntity.ok("Reservation deleted successfully");
    }
}
