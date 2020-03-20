package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class ListFilterTest {
    List<Integer> list;

    @Before
    public void helper(){
        list = new ArrayList<>();
        list.add(-5);
        list.add(2);
        list.add(-2);
        list.add(4);
    }

    @Test
    public void filter(){
        IListFilter filter = Mockito.mock(IListFilter.class);
        Mockito.when(filter.accept(-5)).thenReturn(true);
        Mockito.when(filter.accept(2)).thenReturn(false);
        Mockito.when(filter.accept(-2)).thenReturn(false);
        Mockito.when(filter.accept(4)).thenReturn(true);

        List<Integer> expected = new ArrayList<>();
        expected.add(-5);
        expected.add(4);

        ListFilter filterer = new ListFilter(list);
        List<Integer> result = filterer.filter(filter);

        assertEquals(expected, result);
    }
}
