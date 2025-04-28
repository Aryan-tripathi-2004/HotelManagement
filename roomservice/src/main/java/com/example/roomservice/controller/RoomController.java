package com.example.roomservice.controller;

import com.example.roomservice.dto.ReservationInputDto;
import com.example.roomservice.dto.RoomRequestDto;
import com.example.roomservice.dto.RoomResponseDto;
import com.example.roomservice.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping
    public ResponseEntity<RoomResponseDto> createRoom(@RequestHeader("Authorization") String token,
                                                      @RequestBody RoomRequestDto roomRequestDto) {
        return ResponseEntity.ok(roomService.createRoom(roomRequestDto, token));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomResponseDto> updateRoom(@RequestHeader("Authorization") String token,
                                                      @PathVariable Long id,
                                                      @RequestBody RoomRequestDto roomRequestDto) {
        return ResponseEntity.ok(roomService.updateRoom(id, roomRequestDto, token));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@RequestHeader("Authorization") String token,
                                           @PathVariable Long id) {
        roomService.deleteRoom(id, token);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<RoomResponseDto>> getAllRooms(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(roomService.getAllRooms(token));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomResponseDto> getRoomById(@RequestHeader("Authorization") String token,
                                                       @PathVariable Long id) {
        return ResponseEntity.ok(roomService.getRoomById(id, token));
    }

    @PostMapping("/{roomId}/add-reservation")
    public ResponseEntity<String> addReservationToRoom(@PathVariable Long roomId,
                                                       @RequestBody ReservationInputDto reservationInputDto) {
        roomService.addReservationToRoom(roomId, reservationInputDto);
        return ResponseEntity.ok("Reservation added successfully to room ID: " + roomId);
    }

    @PostMapping("/available")
    public ResponseEntity<List<RoomResponseDto>> getAvailableRooms(@RequestHeader("Authorization") String token,
                                                                   @RequestBody Map<String, String> request) {
        LocalDate date = LocalDate.parse(request.get("date"));
        return ResponseEntity.ok(roomService.getAvailableRoomsByDate(date));
    }

}
