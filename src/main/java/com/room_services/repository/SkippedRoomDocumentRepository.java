package com.room_services.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.room_services.domain.SkippedRoomDocument;

public interface SkippedRoomDocumentRepository extends ReactiveMongoRepository<SkippedRoomDocument, String>{

}
