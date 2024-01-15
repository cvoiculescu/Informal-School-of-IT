package org.voiculescu.siit.temawk15;

import org.voiculescu.siit.temawk15.model.*;

import java.util.ArrayList;
import java.util.List;

public class BookingApp {
    private static List<Accommodation> accommodations;
    private static List<RoomFair> roomFairs;
    private static List<Relation> relations;

    public static void main(String[] args) {
        accommodations = new ArrayList<>();
        roomFairs = new ArrayList<>();
        relations = new ArrayList<>();

        roomFairs.add(RoomFair.createRoomFair(1, 90.5, Season.SPRING));
        roomFairs.add(RoomFair.createRoomFair(2, 120.5, Season.SUMMER));
        roomFairs.add(RoomFair.createRoomFair(3, 80.5, Season.AUTUMN));
        roomFairs.add(RoomFair.createRoomFair(4, 110.5, Season.WINTER));
        roomFairs.add(RoomFair.createRoomFair(5, 90.5, Season.SPRING));
        roomFairs.add(RoomFair.createRoomFair(6, 130.5, Season.SUMMER));
        roomFairs.add(RoomFair.createRoomFair(7, 80.5, Season.AUTUMN));
        roomFairs.add(RoomFair.createRoomFair(8, 120.5, Season.WINTER));
        roomFairs.add(RoomFair.createRoomFair(9, 110, Season.SPRING));
        roomFairs.add(RoomFair.createRoomFair(10, 150, Season.SUMMER));
        roomFairs.add(RoomFair.createRoomFair(11, 100, Season.AUTUMN));
        roomFairs.add(RoomFair.createRoomFair(12, 130, Season.WINTER));

        accommodations.add(Accommodation.createNewRoom(1, AccommodationType.SUITE, BedType.SINGLE, 5, "A Single Bed Suite"));
        accommodations.add(Accommodation.createNewRoom(2, AccommodationType.ROYAL, BedType.QUEEN_SIZE, 2, "A Queen Size Royal Suite"));
        accommodations.add(Accommodation.createNewRoom(3, AccommodationType.ROYAL, BedType.KING_SIZE, 2, "A King Size Royal Suite"));

        for (Accommodation accommodation : accommodations) {
            int pKeyAccommodation = accommodation.getId();
            String type = accommodation.getType().toString();
            String bedType = accommodation.getBedType().toString();
            int maxGuests = accommodation.getMaxGuests();
            String description = accommodation.getDescription();
            Database.insertRecordIntoAccommodation(pKeyAccommodation, type, bedType, maxGuests, description);
        }

        for (RoomFair roomFair : roomFairs) {
            int pKeyRoomFair = roomFair.getId();
            double value = roomFair.getValue();
            Season season = roomFair.getSeason();
            Database.insertRecordIntoRoomFair(pKeyRoomFair, value, season);
        }

        for (int i = 0; i < roomFairs.size(); i++) {
            int pKeyRelation = i + 1;
            Accommodation accommodation = accommodations.get((i / 4));
            RoomFair roomFair = roomFairs.get(i);
            relations.add(Relation.createAccommodationRoomFairRelation(pKeyRelation, accommodation, roomFair));
        }

        for (Relation relation : relations) {
            int pKeyRelation = relation.getId();
            int fKeyAccommodation = relation.getAccommodation().getId();
            int fKeyRoomFair = relation.getRoomFair().getId();
            Database.insertRecordIntoRelationTable(pKeyRelation, fKeyAccommodation, fKeyRoomFair);
        }
    }
}
