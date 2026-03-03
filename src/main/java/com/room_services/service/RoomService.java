package com.room_services.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.room_services.dto.PageDTO;
import com.room_services.dto.RoomDTO;
import com.room_services.dto.RoomFilterDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Component
public interface RoomService {

    Mono<RoomDTO> createRoom(RoomDTO roomDTO);

    Mono<RoomDTO> getRoomById(String id);

    Mono<RoomDTO> updateRoom(String id, RoomDTO roomDTO);

    Mono<Void> deleteRoom(String id);

    //study purpose only
    Flux<RoomDTO> searchRoomByName(String room);

    Flux<RoomDTO> getRoomByFilter(RoomFilterDTO filterDTO);

    Mono<PageDTO<RoomDTO>> getRoomByFilterPagination(RoomFilterDTO filterDTO);
}
