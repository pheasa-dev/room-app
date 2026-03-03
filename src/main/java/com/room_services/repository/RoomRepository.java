package com.room_services.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.room_services.domain.Room;

import reactor.core.publisher.Flux;

public interface RoomRepository extends ReactiveMongoRepository<Room, String> {

	Flux<Room> findByNameContainingIgnoreCase(String name);

	@Query("{'name': ?0}")
	Flux<Room> findRoom(String name);

}
