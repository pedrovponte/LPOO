package com.aor.numbers;

import org.junit.Test;

import static org.junit.Assert.*;

public class DivisibleByFilterTest {
    @Test
    public void acceptZero(){
        DivisibleByFilter filter = new DivisibleByFilter(4);
        assertTrue(filter.accept(0));
    }

    @Test
    public void acceptDivisible(){
        DivisibleByFilter filter = new DivisibleByFilter(5);
        assertTrue(filter.accept(15));
    }

    @Test
    public void notAcceptDivisible(){
        DivisibleByFilter filter = new DivisibleByFilter(2);
        assertFalse(filter.accept(5));
    }
}
