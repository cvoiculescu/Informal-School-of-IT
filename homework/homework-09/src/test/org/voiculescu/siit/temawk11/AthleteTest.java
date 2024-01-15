package org.voiculescu.siit.temawk11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * tests done for Athlete.class
 */
class AthleteTest {

    /**
     * test the SkyTimeResult without misses
     */
    @Test
    void getSkyTotalTimeNoMissesTest() {
        Athlete test = new Athlete(27,"Piotr Smitzer","CZ",new SkyTimeResult(30,10),"xxxxx","xxxxx","xxxxx");
        assertEquals(new SkyTimeResult(30,10),test.getSkyTotalTime());
    }

    /**
     * test the SkyTimeResult with misses
     */
    @Test
    void getSkyTotalTimeWithMissesTest() {
        Athlete test = new Athlete(27,"Jimmy Smiles","UK",new SkyTimeResult(29,15),"xxoox","xooxo","xxxxo");
        assertEquals(new SkyTimeResult(30,15),test.getSkyTotalTime());
    }

    /**
     * checks if the equals is working
     */
    @Test
    void equalsTest() {
        Athlete test = new Athlete(27,"Jimmy Smiles","UK",new SkyTimeResult(29,15),"xxoox","xooxo","xxxxo");
        Athlete test1 = new Athlete(27,"Jimmy Smiles","UK",new SkyTimeResult(29,15),"xxoox","xooxo","xxxxo");
        assertTrue(test.equals(test1));
    }

    /**
     * checks if the compare to works. the compare is done on the SkyTime with penalty.
     */
    @Test
    void compareToTest() {
        Athlete test = new Athlete(27,"Piotr Smitzer","CZ",new SkyTimeResult(30,10),"xxxxx","xxxxx","xxxxx");
        Athlete test1 = new Athlete(27,"Jimmy Smiles","UK",new SkyTimeResult(29,15),"xxoox","xooxo","xxxxo");
        assertEquals(-1, test.compareTo(test1));
    }



}