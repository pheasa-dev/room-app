package com.room_services.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;

import com.room_services.dto.RoomFilterDTO;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class RoomCriteriaBuilder {

    public static Criteria build(RoomFilterDTO filter) {
        List<Criteria> criterias = new ArrayList<>();
        if (Objects.nonNull(filter.getName())) {
            criterias.add(Criteria.where(RoomConstants.FIELD_NAME).is(filter.getName()));
        }

        if (Objects.nonNull(filter.getFloor())) {
            criterias.add(Criteria.where(RoomConstants.FIELD_FLOOR).is(filter.getFloor()));
        }

        if (Objects.nonNull(filter.getPrice()) && Objects.nonNull(filter.getPriceOp())) {
            switch (filter.getPriceOp()) {
                case RoomConstants.OP_LT ->
                        criterias.add(Criteria.where(RoomConstants.FIELD_PRICE).lt(filter.getPrice()));
                case RoomConstants.OP_LTE ->
                        criterias.add(Criteria.where(RoomConstants.FIELD_PRICE).lte(filter.getPrice()));
                case RoomConstants.OP_GT ->
                        criterias.add(Criteria.where(RoomConstants.FIELD_PRICE).gt(filter.getPrice()));
                case RoomConstants.OP_GTE ->
                        criterias.add(Criteria.where(RoomConstants.FIELD_PRICE).gte(filter.getPrice()));
                case RoomConstants.OP_EQ ->
                        criterias.add(Criteria.where(RoomConstants.FIELD_PRICE).is(filter.getPrice()));
                default -> log.warn("Invalide  price operator: {}", filter.getPriceOp());
            }
        } else if (Objects.nonNull(filter.getPriceMax()) && Objects.nonNull(filter.getPriceMax())) {
            criterias
                    .add(Criteria.where(RoomConstants.FIELD_PRICE).gte(filter.getPriceMin()).lte(filter.getPriceMin()));
        }

        // Boolean fields
        if (Objects.nonNull(filter.getHasFan())) {
            criterias.add(Criteria.where(RoomConstants.FIELD_HAS_FAN).is(filter.getHasFan()));
        }
        if (Objects.nonNull(filter.getHasAirConditoner())) {
            criterias.add(Criteria.where(RoomConstants.FIELD_HAS_AIR_CORDITIONER).is(filter.getHasAirConditoner()));
        }
        if (Objects.nonNull(filter.getHasParking())) {
            criterias.add(Criteria.where(RoomConstants.FIELD_HAS_PARKING).is(filter.getHasParking()));
        }
        if (Objects.nonNull(filter.getHasPrivateBathroom())) {
            criterias.add(Criteria.where(RoomConstants.FIELD_HAS_PRIVATE_BATHROOM).is(filter.getHasPrivateBathroom()));
        }
        if (Objects.nonNull(filter.getHasKitchen())) {
            criterias.add(Criteria.where(RoomConstants.FIELD_HAS_KITCHEN).is(filter.getHasKitchen()));
        }
        if (Objects.nonNull(filter.getHasFridge())) {
            criterias.add(Criteria.where(RoomConstants.FIELD_HAS_FRIDGE).is(filter.getHasFridge()));
        }
        if (Objects.nonNull(filter.getHasWiFi())) {
            criterias.add(Criteria.where(RoomConstants.FIELD_HAS_WIFI).is(filter.getHasWiFi()));
        }
        if (Objects.nonNull(filter.getIsSharedRoom())) {
            criterias.add(Criteria.where(RoomConstants.FIELD_IS_SHARED_ROOM).is(filter.getIsSharedRoom()));
        }
        if (Objects.nonNull(filter.getHasPetFriendly())) {
            criterias.add(Criteria.where(RoomConstants.FIELD_IS_PET_FRIENDLY).is(filter.getHasPetFriendly()));
        }
        if (Objects.nonNull(filter.getIsSmokingAllowed())) {
            criterias.add(Criteria.where(RoomConstants.FIELD_IS_SMOKING_ALLOWED).is(filter.getIsSmokingAllowed()));
        }
        if (Objects.nonNull(filter.getHasElevator())) {
            criterias.add(Criteria.where(RoomConstants.FIELD_HAS_ELEVATOR).is(filter.getHasElevator()));
        }
        if (Objects.nonNull(filter.getHasBalcony())) {
            criterias.add(Criteria.where(RoomConstants.FIELD_HAS_BALCONY).is(filter.getHasBalcony()));
        }
        if (Objects.nonNull(filter.getHasWashingMachine())) {
            criterias.add(Criteria.where(RoomConstants.FIELD_HAS_WASHING_MACHINE).is(filter.getHasWashingMachine()));
        }
        if (Objects.nonNull(filter.getHasAirConditoner())) {
            criterias.add(Criteria.where(RoomConstants.FIELD_HAS_AIR_CORDITIONER).is(filter.getHasAirConditoner()));
        }
        if (Objects.nonNull(filter.getHasTV())) {
            criterias.add(Criteria.where(RoomConstants.FIELD_HAS_TV).is(filter.getHasTV()));
        }

        // Enum fields
        if (Objects.nonNull(filter.getRoomType())) {
            criterias.add(Criteria.where(RoomConstants.FIELD_ROOM_TYPE).is(filter.getRoomType()));
        }
        if (Objects.nonNull(filter.getPropertyType())) {
            criterias.add(Criteria.where(RoomConstants.FIELD_PROPERTY_TYPE).is(filter.getPropertyType()));
        }
        if (Objects.nonNull(filter.getGenderPreference())) {
            criterias.add(Criteria.where(RoomConstants.FIELD_GENDER_PREFERENCE).is(filter.getGenderPreference()));
        }

        // Verified
        if (Objects.nonNull(filter.getVerifiedListing())) {
            criterias.add(Criteria.where(RoomConstants.FIELD_VERIFIED_LISTING).is(filter.getVerifiedListing()));
        }

        // Date range
        if (Objects.nonNull(filter.getAvailableFrom())) {
            criterias.add(Criteria.where(RoomConstants.FIELD_AVAILABLE_FROM).is(filter.getAvailableFrom()));
        }
        if (Objects.nonNull(filter.getAvailableTo())) {
            criterias.add(Criteria.where(RoomConstants.FIELD_AVAILABLE_TO).is(filter.getAvailableTo()));
        }

        // minStayMonths
        if (Objects.nonNull(filter.getMinStayMonths())) {
            criterias.add(Criteria.where(RoomConstants.FIELD_MIN_STAY_MONTHS).is(filter.getMinStayMonths()));
        }

        // maxOccupants
        if (Objects.nonNull(filter.getMaxOccupants())) {
            criterias.add(Criteria.where(RoomConstants.FIELD_MAX_OCCUPANTS).is(filter.getMaxOccupants()));
        }

        return criterias.isEmpty() ? new Criteria() : new Criteria().andOperator(criterias.toArray(new Criteria[0]));
    }

    public static Sort sort(RoomFilterDTO filter) {
        Sort.Direction direction = "desc".equalsIgnoreCase(filter.getDirection()) ? Sort.Direction.DESC
                : Sort.Direction.ASC;

        String sortField = Objects.nonNull(filter.getSortBy()) ? filter.getSortBy() : RoomConstants.FIELD_NAME;
        if (!RoomConstants.ALLOWED_SORT_FILDS.contains(sortField)) {
            throw new IllegalArgumentException("Invalid sort field: " + sortField);
        }
        return Sort.by(direction, sortField);
    }
}
