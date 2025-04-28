package com.example.roomservice.service;

import com.example.roomservice.dto.ReservationInputDto;
import com.example.roomservice.dto.RoomRequestDto;
import com.example.roomservice.dto.RoomResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface RoomService {
    RoomResponseDto createRoom(RoomRequestDto roomRequestDto, String token);
    RoomResponseDto updateRoom(Long id, RoomRequestDto roomRequestDto, String token);
    void deleteRoom(Long id, String token);
    List<RoomResponseDto> getAllRooms(String token);
    RoomResponseDto getRoomById(Long id, String token);
    void addReservationToRoom(Long roomId, ReservationInputDto reservationInputDto);
    List<RoomResponseDto> getAvailableRoomsByDate(LocalDate date);
}
