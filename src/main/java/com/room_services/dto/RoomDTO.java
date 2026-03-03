package com.room_services.dto;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.room_services.domain.Location;
import com.room_services.enumeration.GenderPreference;
import com.room_services.enumeration.PropertyType;
import com.room_services.enumeration.RoomType;

import lombok.Data;

@Data
public class RoomDTO {
	private String id;
	private String name;
	private Double price;
	private Integer floor;
	private Double roomSize;
	private Location location;
	private Boolean hasFan;
	private Boolean hasAirConditioner;
	private Boolean hasParking;
	private Boolean hasPrivateBathroom;
	private Boolean hasBalcony;
	private Boolean hasKitchen;
	private Boolean hasFridge;
	private Boolean hasWashingMachine;
	private Boolean hasTV;
	private Boolean hasWiFi;
	private Boolean hasElevator;
	private Integer maxOccupants;
	private Boolean isPetFriendly;
	private Boolean isSmookingAllowed;
	private Boolean isSharedRoom;
	private GenderPreference genderPreference;
	private RoomType roomType;
	private PropertyType propertyType;
	private Double distanceToCenter;
	private List<String> nearbyLandsmarks;
	private Boolean isUtilityIncluded;
	private Boolean depositRequired;
	private Integer minStayMonths;
	private Boolean hasPhotos;
	private Integer photoCount;
	private Boolean hasVideoTour;
	private Boolean verifiedListing;
	private LocalDateTime availableFrom;
	private LocalDateTime availableTo;
	private LocalDateTime createAt;
	private LocalDateTime lastUpdated;
	private Map<String, Object> extraAttributes = new HashMap<>();
}
