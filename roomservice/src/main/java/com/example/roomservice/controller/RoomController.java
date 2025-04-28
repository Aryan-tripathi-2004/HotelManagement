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
    public ResponseEntity<RoomResponseDto> createRoom(@RequestBody RoomRequestDto roomRequestDto) {
        return ResponseEntity.ok(roomService.createRoom(roomRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomResponseDto> updateRoom(@PathVariable Long id,
                                                      @RequestBody RoomRequestDto roomRequestDto) {
        return ResponseEntity.ok(roomService.updateRoom(id, roomRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<RoomResponseDto>> getAllRooms() {
        return ResponseEntity.ok(roomService.getAllRooms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomResponseDto> getRoomById(@PathVariable Long id) {
        return ResponseEntity.ok(roomService.getRoomById(id));
    }

    @PostMapping("/{roomId}/add-reservation")
    public ResponseEntity<String> addReservationToRoom(@PathVariable Long roomId,
                                                       @RequestBody ReservationInputDto reservationInputDto) {
        roomService.addReservationToRoom(roomId, reservationInputDto);
        return ResponseEntity.ok("Reservation added successfully to room ID: " + roomId);
    }

    @PostMapping("/available")
    public ResponseEntity<List<RoomResponseDto>> getAvailableRooms(@RequestBody Map<String, String> request) {
        LocalDate date = LocalDate.parse(request.get("date"));
        return ResponseEntity.ok(roomService.getAvailableRoomsByDate(date));
    }

}
