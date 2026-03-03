package com.room_services.service;

import org.springframework.http.codec.multipart.FilePart;

import com.room_services.dto.RoomImportSummary;

import reactor.core.publisher.Mono;

public interface RoomImportService {
	Mono<RoomImportSummary> importRoom(FilePart filePart);
}
