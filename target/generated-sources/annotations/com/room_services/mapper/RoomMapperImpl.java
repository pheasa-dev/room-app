package com.room_services.mapper;

import com.room_services.domain.Room;
import com.room_services.dto.RoomDTO;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-03T16:17:42+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.43.0.v20250819-1513, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class RoomMapperImpl implements RoomMapper {

    @Override
    public Room toRoom(RoomDTO roomDTO) {
        if ( roomDTO == null ) {
            return null;
        }

        Room.RoomBuilder room = Room.builder();

        room.availableFrom( roomDTO.getAvailableFrom() );
        room.availableTo( roomDTO.getAvailableTo() );
        room.createAt( roomDTO.getCreateAt() );
        room.depositRequired( roomDTO.getDepositRequired() );
        room.distanceToCenter( roomDTO.getDistanceToCenter() );
        Map<String, Object> map = roomDTO.getExtraAttributes();
        if ( map != null ) {
            room.extraAttributes( new LinkedHashMap<String, Object>( map ) );
        }
        room.floor( roomDTO.getFloor() );
        room.genderPreference( roomDTO.getGenderPreference() );
        room.hasAirConditioner( roomDTO.getHasAirConditioner() );
        room.hasBalcony( roomDTO.getHasBalcony() );
        room.hasElevator( roomDTO.getHasElevator() );
        room.hasFan( roomDTO.getHasFan() );
        room.hasFridge( roomDTO.getHasFridge() );
        room.hasKitchen( roomDTO.getHasKitchen() );
        room.hasParking( roomDTO.getHasParking() );
        room.hasPhotos( roomDTO.getHasPhotos() );
        room.hasPrivateBathroom( roomDTO.getHasPrivateBathroom() );
        room.hasTV( roomDTO.getHasTV() );
        room.hasVideoTour( roomDTO.getHasVideoTour() );
        room.hasWashingMachine( roomDTO.getHasWashingMachine() );
        room.hasWiFi( roomDTO.getHasWiFi() );
        room.id( roomDTO.getId() );
        room.isPetFriendly( roomDTO.getIsPetFriendly() );
        room.isSharedRoom( roomDTO.getIsSharedRoom() );
        room.isSmookingAllowed( roomDTO.getIsSmookingAllowed() );
        room.isUtilityIncluded( roomDTO.getIsUtilityIncluded() );
        room.lastUpdated( roomDTO.getLastUpdated() );
        room.location( roomDTO.getLocation() );
        room.maxOccupants( roomDTO.getMaxOccupants() );
        room.minStayMonths( roomDTO.getMinStayMonths() );
        room.name( roomDTO.getName() );
        List<String> list = roomDTO.getNearbyLandsmarks();
        if ( list != null ) {
            room.nearbyLandsmarks( new ArrayList<String>( list ) );
        }
        room.photoCount( roomDTO.getPhotoCount() );
        room.price( roomDTO.getPrice() );
        room.propertyType( roomDTO.getPropertyType() );
        room.roomSize( roomDTO.getRoomSize() );
        room.roomType( roomDTO.getRoomType() );
        room.verifiedListing( roomDTO.getVerifiedListing() );

        return room.build();
    }

    @Override
    public RoomDTO toRoomDTO(Room room) {
        if ( room == null ) {
            return null;
        }

        RoomDTO roomDTO = new RoomDTO();

        roomDTO.setAvailableFrom( room.getAvailableFrom() );
        roomDTO.setAvailableTo( room.getAvailableTo() );
        roomDTO.setCreateAt( room.getCreateAt() );
        roomDTO.setDepositRequired( room.getDepositRequired() );
        roomDTO.setDistanceToCenter( room.getDistanceToCenter() );
        Map<String, Object> map = room.getExtraAttributes();
        if ( map != null ) {
            roomDTO.setExtraAttributes( new LinkedHashMap<String, Object>( map ) );
        }
        roomDTO.setFloor( room.getFloor() );
        roomDTO.setGenderPreference( room.getGenderPreference() );
        roomDTO.setHasAirConditioner( room.getHasAirConditioner() );
        roomDTO.setHasBalcony( room.getHasBalcony() );
        roomDTO.setHasElevator( room.getHasElevator() );
        roomDTO.setHasFan( room.getHasFan() );
        roomDTO.setHasFridge( room.getHasFridge() );
        roomDTO.setHasKitchen( room.getHasKitchen() );
        roomDTO.setHasParking( room.getHasParking() );
        roomDTO.setHasPhotos( room.getHasPhotos() );
        roomDTO.setHasPrivateBathroom( room.getHasPrivateBathroom() );
        roomDTO.setHasTV( room.getHasTV() );
        roomDTO.setHasVideoTour( room.getHasVideoTour() );
        roomDTO.setHasWashingMachine( room.getHasWashingMachine() );
        roomDTO.setHasWiFi( room.getHasWiFi() );
        roomDTO.setId( room.getId() );
        roomDTO.setIsPetFriendly( room.getIsPetFriendly() );
        roomDTO.setIsSharedRoom( room.getIsSharedRoom() );
        roomDTO.setIsSmookingAllowed( room.getIsSmookingAllowed() );
        roomDTO.setIsUtilityIncluded( room.getIsUtilityIncluded() );
        roomDTO.setLastUpdated( room.getLastUpdated() );
        roomDTO.setLocation( room.getLocation() );
        roomDTO.setMaxOccupants( room.getMaxOccupants() );
        roomDTO.setMinStayMonths( room.getMinStayMonths() );
        roomDTO.setName( room.getName() );
        List<String> list = room.getNearbyLandsmarks();
        if ( list != null ) {
            roomDTO.setNearbyLandsmarks( new ArrayList<String>( list ) );
        }
        roomDTO.setPhotoCount( room.getPhotoCount() );
        roomDTO.setPrice( room.getPrice() );
        roomDTO.setPropertyType( room.getPropertyType() );
        roomDTO.setRoomSize( room.getRoomSize() );
        roomDTO.setRoomType( room.getRoomType() );
        roomDTO.setVerifiedListing( room.getVerifiedListing() );

        return roomDTO;
    }

    @Override
    public void updateRoomFromDTO(RoomDTO roomDTO, Room room) {
        if ( roomDTO == null ) {
            return;
        }

        room.setAvailableFrom( roomDTO.getAvailableFrom() );
        room.setAvailableTo( roomDTO.getAvailableTo() );
        room.setCreateAt( roomDTO.getCreateAt() );
        room.setDepositRequired( roomDTO.getDepositRequired() );
        room.setDistanceToCenter( roomDTO.getDistanceToCenter() );
        if ( room.getExtraAttributes() != null ) {
            Map<String, Object> map = roomDTO.getExtraAttributes();
            if ( map != null ) {
                room.getExtraAttributes().clear();
                room.getExtraAttributes().putAll( map );
            }
            else {
                room.setExtraAttributes( null );
            }
        }
        else {
            Map<String, Object> map = roomDTO.getExtraAttributes();
            if ( map != null ) {
                room.setExtraAttributes( new LinkedHashMap<String, Object>( map ) );
            }
        }
        room.setFloor( roomDTO.getFloor() );
        room.setGenderPreference( roomDTO.getGenderPreference() );
        room.setHasAirConditioner( roomDTO.getHasAirConditioner() );
        room.setHasBalcony( roomDTO.getHasBalcony() );
        room.setHasElevator( roomDTO.getHasElevator() );
        room.setHasFan( roomDTO.getHasFan() );
        room.setHasFridge( roomDTO.getHasFridge() );
        room.setHasKitchen( roomDTO.getHasKitchen() );
        room.setHasParking( roomDTO.getHasParking() );
        room.setHasPhotos( roomDTO.getHasPhotos() );
        room.setHasPrivateBathroom( roomDTO.getHasPrivateBathroom() );
        room.setHasTV( roomDTO.getHasTV() );
        room.setHasVideoTour( roomDTO.getHasVideoTour() );
        room.setHasWashingMachine( roomDTO.getHasWashingMachine() );
        room.setHasWiFi( roomDTO.getHasWiFi() );
        room.setId( roomDTO.getId() );
        room.setIsPetFriendly( roomDTO.getIsPetFriendly() );
        room.setIsSharedRoom( roomDTO.getIsSharedRoom() );
        room.setIsSmookingAllowed( roomDTO.getIsSmookingAllowed() );
        room.setIsUtilityIncluded( roomDTO.getIsUtilityIncluded() );
        room.setLastUpdated( roomDTO.getLastUpdated() );
        room.setLocation( roomDTO.getLocation() );
        room.setMaxOccupants( roomDTO.getMaxOccupants() );
        room.setMinStayMonths( roomDTO.getMinStayMonths() );
        room.setName( roomDTO.getName() );
        if ( room.getNearbyLandsmarks() != null ) {
            List<String> list = roomDTO.getNearbyLandsmarks();
            if ( list != null ) {
                room.getNearbyLandsmarks().clear();
                room.getNearbyLandsmarks().addAll( list );
            }
            else {
                room.setNearbyLandsmarks( null );
            }
        }
        else {
            List<String> list = roomDTO.getNearbyLandsmarks();
            if ( list != null ) {
                room.setNearbyLandsmarks( new ArrayList<String>( list ) );
            }
        }
        room.setPhotoCount( roomDTO.getPhotoCount() );
        room.setPrice( roomDTO.getPrice() );
        room.setPropertyType( roomDTO.getPropertyType() );
        room.setRoomSize( roomDTO.getRoomSize() );
        room.setRoomType( roomDTO.getRoomType() );
        room.setVerifiedListing( roomDTO.getVerifiedListing() );
    }
}
