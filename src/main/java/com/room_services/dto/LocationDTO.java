package com.room_services.dto;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationDTO {
		private String country;
		private String city;
		private String district;
		private String street;
		private String fullAddress;
//		private GeoJsonPoint coordinates; // GeoJsonPoint format for geospatail quries.
}
