package org.voiculescu.siit.temawk11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkyTimeResultTest {

    /**
     * verifies if the getTimeInSeconds works
     */
    @Test
    void getTimeInSecondsTest() {
        SkyTimeResult time = new SkyTimeResult(10, 10);
        Integer result = time.getTimeInSeconds();
        assertEquals(610, result);
    }

    /**
     * test if the equals is made on values
     */
    @Test
    void equalsTest() {
        SkyTimeResult time1 = new SkyTimeResult(10, 10);
        SkyTimeResult time2 = new SkyTimeResult(10, 10);
        assertTrue(time1.equals(time2));
    }

    /**
     * test if a new generated SkyTimeResult just with seconds is correctly converted into minutes:seconds
     */
    @Test
    void skyTimeResultInSeconds() {
        SkyTimeResult time = new SkyTimeResult(70);
        assertTrue((time.getMinutes() == 1) && (time.getSeconds() == 10));
    }
}