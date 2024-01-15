package org.voiculescu.siit.temawk15.model;

/**
 * this class fully describes the <b>accommodation</b> table of the <b>booking</b> database
 */
public class Accommodation {

    private int id;
    private AccommodationType type;
    private String description;
    private int maxGuests;
    private BedType bedType;

    /**
     * keeps the Accommodation object creation just to the factory method
     */
    private Accommodation() {
    }

    /**
     * static Factory method which generated an accommodation
     *
     * @param id          the <b>primary key</b>  for a new accommodation
     * @param type        the <b>type</b> field of accommodation table
     * @param bedType     the <b>bed_type</b> field of accommodation table
     * @param guests      the<b>max_guests</b> field of the accommodation table
     * @param description the<b>description</b> field of the accommodation table
     * @return a new <b>Accommodation</b> object
     * @see AccommodationType
     */
    public static Accommodation createNewRoom(int id, AccommodationType type, BedType bedType, int guests, String description) {
        Accommodation accommodation = new Accommodation();
        accommodation.setId(id);
        accommodation.setType(type);
        accommodation.setBedType(bedType);
        accommodation.setMaxGuests(guests);
        accommodation.setDescription(description);
        return accommodation;
    }

    public AccommodationType getType() {
        return type;
    }

    public void setType(AccommodationType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    public BedType getBedType() {
        return bedType;
    }

    public void setBedType(BedType bedType) {
        this.bedType = bedType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
