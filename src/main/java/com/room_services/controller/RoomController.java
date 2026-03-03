package com.room_services.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.room_services.dto.PageDTO;
import com.room_services.dto.RoomDTO;
import com.room_services.dto.RoomFilterDTO;
import com.room_services.dto.RoomImportSummary;
import com.room_services.service.RoomImportService;
import com.room_services.service.RoomService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/rooms")
public class RoomController {

	private final RoomService roomService;
	private final RoomImportService roomImportService;

	// room_servic
	@PostMapping
	@Operation(summary = "Create Room", parameters = @Parameter(in = ParameterIn.PATH, name = "createRoom"))
	public Mono<RoomDTO> createRoom(@Valid @RequestBody RoomDTO roomDTO) {
		return roomService.createRoom(roomDTO);
	}

	@GetMapping("/{roomId}")
	@Operation(summary = "Get room by ID", parameters = @Parameter(in = ParameterIn.PATH, name = "roomId"))
	public Mono<RoomDTO> getRoomById(@PathVariable String roomId) {
		return roomService.getRoomById(roomId);
	}

	@PutMapping("/{roomId}")
	@Operation(summary = "Update room with ID", parameters = @Parameter(in = ParameterIn.PATH, name = "updateRoom"))
	public Mono<RoomDTO> updateRoom(@PathVariable String roomId, @RequestBody RoomDTO roomDTO) {
		return roomService.updateRoom(roomId, roomDTO);
	}

	@DeleteMapping("/{roomId}")
	@Operation(summary = "Delete room by ID", parameters = @Parameter(in = ParameterIn.PATH, name = "deleteRoom"))
	public Mono<Void> deteleRoom(@PathVariable String roomId) {
		return roomService.deleteRoom(roomId);
	}

	@GetMapping("/search")
	public Flux<RoomDTO> findRoomByName(@RequestParam String name) {
		return roomService.searchRoomByName(name);
	}

	@GetMapping("/searchs")
	public Flux<RoomDTO> getRoomByFilter(RoomFilterDTO roomFilterDTO) {
		return roomService.getRoomByFilter(roomFilterDTO);
	}

	@GetMapping("/searchs/pagination")
	public Mono<PageDTO<RoomDTO>> getRoomByFilterPagination(RoomFilterDTO roomFilterDTO) {
		return roomService.getRoomByFilterPagination(roomFilterDTO);
	}

	@GetMapping("/searchs/pagination2")
	public Mono<ResponseEntity<PageDTO<RoomDTO>>> getRoomByFilterPaginationWithHeader(RoomFilterDTO roomFilterDTO) {
		return roomService.getRoomByFilterPagination(roomFilterDTO)
                .map(page -> ResponseEntity.ok()
				.header("X-Total-Count", String.valueOf(page.getTotalElements()))
                        .body(page));
	}

	@PostMapping(value = "/upload-excel", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Mono<RoomImportSummary> uploadExcel(@RequestPart("file") FilePart filePart) {
		return roomImportService.importRoom(filePart);
	}
}
