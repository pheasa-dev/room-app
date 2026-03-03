package com.room_services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Repository;

import com.room_services.domain.Room;
import com.room_services.dto.RoomDTO;

@Mapper(componentModel = "spring")
@Repository
public interface RoomMapper {

	Room toRoom(RoomDTO roomDTO);

	RoomDTO toRoomDTO(Room room);

	void updateRoomFromDTO(RoomDTO roomDTO, @MappingTarget Room room);

}
