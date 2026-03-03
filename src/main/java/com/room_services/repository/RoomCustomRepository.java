package com.room_services.repository;

import org.springframework.data.mongodb.core.query.Query;

import com.room_services.domain.Room;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RoomCustomRepository {

	Flux<Room> findByFilter(Query query);

	Mono<Long> coundByFilter(Query query);
}
