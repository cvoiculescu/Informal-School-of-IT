package org.voiculescu.siit.temawk11;

/**
 * this class defines an Athlete
 */
public class Athlete implements Comparable<Athlete> {
    private int number;
    private String name;
    private String countryCode;
    private SkyTimeResult skyTimeResult;
    private String firstShootingRange;
    private String secondShootingRange;
    private String thirdShootingRange;

    /**
     * This will construct a new Athlete based on following parameters
     * @param number is the Athlete Number, which is an integer greater than 0
     * @param name is the Athlete Name
     * @param countryCode is the Country Code
     * @param skyTimeResult is the skiing time result of the athlete (minute:seconds)
     * @param firstShootingRange is a String of 5 chars, where "x" is hit and "o" is missed
     * @param secondShootingRange is a String of 5 chars, where "x" is hit and "o" is missed
     * @param thirdShootingRange is a String of 5 chars, where "x" is hit and "o" is missed
     */
    public Athlete(int number, String name, String countryCode, SkyTimeResult skyTimeResult, String firstShootingRange, String secondShootingRange, String thirdShootingRange) {
        this.number = number;
        this.name = name;
        this.countryCode = countryCode;
        this.skyTimeResult = skyTimeResult;
        this.firstShootingRange = firstShootingRange;
        this.secondShootingRange = secondShootingRange;
        this.thirdShootingRange = thirdShootingRange;
    }

    /**
     * this method calculates the penalty time based on how many misses the athlete has
     * @return the result is 10 seconds multiplied with the number of misses
     */
    private Integer getCalculatedPenaltyTime() {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (firstShootingRange.charAt(i) == 'o') {
                count++;
            }
            if (secondShootingRange.charAt(i) == 'o') {
                count++;
            }
            if (thirdShootingRange.charAt(i) == 'o') {
                count++;
            }
        }
        return count * 10;
    }

    /**
     * gets the total time which consist of skiing time added the penalty time/
     * @return SkyTimeResult (minutes:seconds)
     */
    public SkyTimeResult getSkyTotalTime() {
        Integer total = skyTimeResult.getTimeInSeconds() + getCalculatedPenaltyTime();
        return new SkyTimeResult(total);
    }

    /**
     * the Athlete is identical if the competition number is the same
     * @param o is the athlete to compare with
     * @return true if the two Athletes are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Athlete athlete = (Athlete) o;

        return number == athlete.number;
    }

    /**
     * the has code is based on the Athlete number
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public int compareTo(Athlete o) {
        Integer comparedTime = this.skyTimeResult.getTimeInSeconds() + this.getCalculatedPenaltyTime();
        Integer comparedToTime = o.skyTimeResult.getTimeInSeconds() + o.getCalculatedPenaltyTime();
        return comparedTime.compareTo(comparedToTime);
    }

    @Override
    public String toString() {
        return this.name+" "+ getSkyTotalTime().toString()+" ("+skyTimeResult.toString()+" + "+getCalculatedPenaltyTime()+")";
    }
}
