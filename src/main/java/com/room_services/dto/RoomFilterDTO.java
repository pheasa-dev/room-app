package com.room_services.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.room_services.enumeration.GenderPreference;
import com.room_services.enumeration.PropertyType;
import com.room_services.enumeration.RoomType;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomFilterDTO {
	@Schema(description = "Exact match for room name", example = "Cozy studio aprtment")
	private String name;
	@Schema(description = "Exact match for floor number", example = "3")
	private Integer floor;
	@Schema(description = "size room with  a spacify with widht and hight", example = "4*6")
	private Double roomSize;
	@Schema(description = "Price filter with a specifi operator(lt,lte,gt,gte,eq)", example = "1")
	private Double price;
	@Schema(description = "Price filter with a specifi operator(lt,lte,gt,gte,eq)", example = "lt")
	private String priceOp;
	@Schema(description = "Minimum price for range search ", example = "2000")
	private String priceMin;
	@Schema(description = "Maximum price for range search", example = "500")
	private String priceMax;
	@Schema(description = "Minimum room size square meters ", example = "7")
	private String roomSizeMin;
	@Schema(description = "Maximum room size square meters", example = "20")
	private String roomSizeMax;
	@Schema(description = "City where the room is located", example = "Phnom Penh")
	private String city;
	@Schema(description = "District where the room is located", example = "Toek Thla")
	private String district;
	@Schema(description = "Has Fan", example = "true")
	private Boolean hasFan;
	@Schema(description = "Has Air Conditioner", example = "true")
	private Boolean hasAirConditoner;
	@Schema(description = "Has Parking", example = "true")
	private Boolean hasParking;
	@Schema(description = "Has Bathroom", example = "true")
	private Boolean hasPrivateBathroom;
	@Schema(description = "Has Balcony", example = "true")
	private Boolean hasBalcony;
	@Schema(description = "Has Kitchen", example = "true")
	private Boolean hasKitchen;
	@Schema(description = "Has Fridge", example = "true")
	private Boolean hasFridge;
	@Schema(description = "Has Washing Machine", example = "false")
	private Boolean hasWashingMachine;
	@Schema(description = "Has TV", example = "true")
	private Boolean hasTV;
	@Schema(description = "Has WiFi", example = "true")
	private Boolean hasWiFi;
	@Schema(description = "Has Elevator", example = "false")
	private Boolean hasElevator;
	@Schema(description = "Has Pet Friendly", example = "true")
	private Boolean hasPetFriendly;
	@Schema(description = "Has Smoking Allowed", example = "false")
	private Boolean isSmokingAllowed;
	@Schema(description = "Has Shared Room", example = "false")
	private Boolean isSharedRoom;
	@Schema(description = "Gedner Preference for tenant", example = "Female")
	private  GenderPreference genderPreference;
	@Schema(description = "Room Type", example = "STUDIO")
	private RoomType roomType;
	@Schema(description = "Property Type ", example = "APARTMENT")
	private PropertyType propertyType;
	@Schema(description = "Utility Included in price", example = "true")
	private Boolean isUtilityIncluded;
	@Schema(description = "Deposit Requied", example = "false")
	private Boolean depositRequired;
	@Schema(description = "Minimum stay in month (=> filter)", example = "6")
	private Integer minStayMonths;
	@Schema(description = "Maximum Occupants allowed (<= filter)", example = "4")
	private Integer maxOccupants;
	@Schema(description = "Available from date (>= filter)", example = "2025-09-01T00:UTC")
	private LocalDateTime availableFrom;
	@Schema(description = "Available To date (>= filter)", example = "2025-09-01T00:UTC")
	private LocalDateTime availableTo;
	@Schema(description = "Nearby landmarks (contains match)", example = "[university, institute hospital...]")
	private List<String> nearbyLandmarks;
	@Schema(description = "Listing is Verified", example = "true")
	private Boolean verifiedListing;
	@Schema(description = "Sort by field name (ex: name,floor,price,createdAt) ", example = "desc,asc")
	private String sortBy;
	@Schema(description = "Sort Direction: asc or desc", example = "asc")
	private String direction;
	@Schema(description = "Page number (for pagination)", example = "0")
	private Integer page;
	@Schema(description = "For size room")
	private Integer size;
	@Schema(description = "Longitude for geo search", example = "102.245")
	private Double nearLng;
	@Schema(description = "Latitude for geo search", example = "123.245")
	private String nearLat;
	@Schema(description = "Max distance in meter for geo search", example = "5000")
	private String maxDistanceMeters;

}
