package com.room_services.service.impl;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.room_services.domain.Room;
import com.room_services.dto.PageDTO;
import com.room_services.dto.RoomDTO;
import com.room_services.dto.RoomFilterDTO;
import com.room_services.exception.RoomNotFoundException;
import com.room_services.mapper.RoomMapper;
import com.room_services.repository.RoomCustomRepository;
import com.room_services.repository.RoomRepository;
import com.room_services.service.RoomService;
import com.room_services.util.RoomCriteriaBuilder;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

	private final RoomRepository roomRepository;
	private final RoomMapper roomMapper;
	private final RoomCustomRepository roomCustomRepository;

	@Override
	public Mono<RoomDTO> createRoom(RoomDTO roomDTO) {
		log.info("Creating room to DB: {}", roomDTO);
		Room room = roomMapper.toRoom(roomDTO);
		return roomRepository.save(room).doOnSuccess(saved -> log.info("Room created successfully : {}", saved))
				.map(roomMapper::toRoomDTO);
	}

	@Override
	public Mono<RoomDTO> getRoomById(String id) {
		log.debug("Retrieving room with ID: {}", id);
		return roomRepository.findById(id).switchIfEmpty(Mono.error(new RoomNotFoundException(id)))
				.doOnNext(room -> log.info("Room received: {}", room)).map(roomMapper::toRoomDTO);
	}

	@Override
	public Mono<RoomDTO> updateRoom(String id, RoomDTO roomDTO) {
		log.debug("updating room ID: {} with data: {}", id, roomDTO);
		return roomRepository.findById(id).switchIfEmpty(Mono.error(new RoomNotFoundException(id)))
				.flatMap(existing -> {
					roomMapper.updateRoomFromDTO(roomDTO, existing);
					Mono<Room> monoRoom = roomRepository.save(existing);
					return monoRoom;
				}).map(roomMapper::toRoomDTO);
	}

	@Override
	public Mono<Void> deleteRoom(String id) {
		log.debug("Deleting room with ID: {}", id);
		return roomRepository.deleteById(id).switchIfEmpty(Mono.error(new RoomNotFoundException(id)))
				.doOnSuccess(deleted -> log.info("Room deleted successfully!! : {}", id));
	}

	@Override
	public Flux<RoomDTO> searchRoomByName(String name) {
		return roomRepository.findRoom(name).map(roomMapper::toRoomDTO);
	}

	@Override
	public Flux<RoomDTO> getRoomByFilter(RoomFilterDTO filterDTO) {
		Criteria criteria = RoomCriteriaBuilder.build(filterDTO);
		return roomCustomRepository.findByFilter(new Query(criteria)).map(roomMapper::toRoomDTO);
	}

	@Override
	public Mono<PageDTO<RoomDTO>> getRoomByFilterPagination(RoomFilterDTO filterDTO) {
		Criteria criteria = RoomCriteriaBuilder.build(filterDTO);
		Mono<Long> countMono = roomCustomRepository.coundByFilter(new Query(criteria));
		Query query = new Query(criteria).skip((long) filterDTO.getPage() * filterDTO.getSize());

		query.with((Pageable) RoomCriteriaBuilder.sort(filterDTO));
		Flux<RoomDTO> contentFlux = roomCustomRepository.findByFilter(query).map(roomMapper::toRoomDTO);
		return Mono.zip(countMono, contentFlux.collectList()).map(tuple -> {
			long total = tuple.getT1();
			List<RoomDTO> content = tuple.getT2();
			int size = (int) (filterDTO.getPrice() > 0 ? filterDTO.getPrice() : 1);
			int totalPages = (int) Math.ceil((double) total / size);
			return new PageDTO<RoomDTO>(filterDTO.getPage(), size, total, totalPages, content);
		});
	}
}
