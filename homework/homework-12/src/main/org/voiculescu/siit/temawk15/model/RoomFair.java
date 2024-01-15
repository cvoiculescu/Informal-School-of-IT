package org.voiculescu.siit.temawk15.model;

/**
 * This Class fully define a Room Fair
 * This is used to populate the <b>room_fair</b> table into <b>booking</b> database
 */
public class RoomFair {
    private double value;
    private Season season;
    private int id;

    /**
     * Ensure that the RoomFair object is created through createRoomFair
     */
    private RoomFair() {
    }

    /**
     * this method is used to generate RoomFair objects
     *
     * @param value  the price for the fair
     * @param season the season of the fair
     * @return a new RoomFair object
     */
    public static RoomFair createRoomFair(int id, double value, Season season) {
        RoomFair roomFair = new RoomFair();
        roomFair.setId(id);
        roomFair.setSeason(season);
        roomFair.setValue(value);
        return roomFair;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}
