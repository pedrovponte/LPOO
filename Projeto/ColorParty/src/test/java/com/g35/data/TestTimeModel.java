package com.g35.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestTimeModel {
    @Test
    public void testGetTIme() {
        TimeModel timeModel = new TimeModel(2500);
        assertTrue(timeModel.getTime() > 0);
        assertEquals(2500, timeModel.getTime());
    }

    @Test
    public void testSetTime() {
        TimeModel timeModel = new TimeModel(2500);
        timeModel.setTime(5000);
        assertEquals(5000, timeModel.getTime());
    }
}
