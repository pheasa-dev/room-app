package com.room_services.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Location {
	private String country;
	private String city;
	private String district;
	private String street;
	private String fullAddress;
//	private GeoJsonPoint coordinates; 
}
