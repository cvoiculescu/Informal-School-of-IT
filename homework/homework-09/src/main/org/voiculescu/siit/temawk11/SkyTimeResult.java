package org.voiculescu.siit.temawk11;

/**
 * this class defines a Time result formed from minutes and seconds
 */
public class SkyTimeResult {
    private Integer minutes;
    private Integer seconds;

    /**
     * generates a new time result based on minutes and seconds
     * @param minutes the minutes of the new time
     * @param seconds the seconds of the new time
     */
    public SkyTimeResult(Integer minutes, Integer seconds) {
        this.minutes = minutes;
        this.seconds = seconds;
    }

    /**
     * generates a new time result based on a total of seconds
     * the seconds will be converted in minutes and seconds.
     * @param seconds the provided time in seconds
     */
    public SkyTimeResult(Integer seconds) {
        this(seconds / 60, seconds % 60);
    }

    /**
     * gets the minutes value of actual time
     * @return minutes
     */
    public Integer getMinutes() {
        return minutes;
    }

    /**
     * gets the seconds value of the actual time
     * @return seconds
     */
    public Integer getSeconds() {
        return seconds;
    }

    /**
     * convert the actual time in seconds
     * @return the converted time in seconds
     */
    public Integer getTimeInSeconds() {
        return this.minutes * 60 + this.seconds;
    }

    /**
     * the skyTime is the same just if minutes are equals and seconds are equals
     * @param o the skyType compared to
     * @return true if the minutes are equal and seconds are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SkyTimeResult that = (SkyTimeResult) o;

        if (!minutes.equals(that.minutes)) return false;
        return seconds.equals(that.seconds);
    }

    /**
     * the hashcode is generated based on minutes and seconds
     * @return the time hashcode
     */
    @Override
    public int hashCode() {
        int result = minutes.hashCode();
        result = 31 * result + seconds.hashCode();
        return result;
    }

    /**
     * get the value of the time as minutes:seconds
     * @return a String like minutes:seconds
     */
    @Override
    public String toString() {
        return minutes + ":" + seconds;
    }
}
