package com.example.reservationservice.feign;

import com.example.reservationservice.dto.ReservationRequestDto;
import com.example.reservationservice.dto.RoomPriceResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "room-service")
public interface RoomFeignClient {

    @PostMapping("/api/rooms/{roomId}/add-reservation")
    void addReservationToRoom(@PathVariable("roomId") Long roomId, @RequestBody ReservationRequestDto reservationRequestDto);

    @GetMapping("/api/rooms/roomNumber/{roomNumber}")
    RoomPriceResponseDto getRoomPricesByRoomNumber(@PathVariable("roomNumber") String roomNumber);
}
