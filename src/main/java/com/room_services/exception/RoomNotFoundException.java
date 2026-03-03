package com.room_services.exception;

public class RoomNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RoomNotFoundException(String id) {
		super("Room not found with ID: " + id);
	}
}
