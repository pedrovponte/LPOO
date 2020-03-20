package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {
    List<Integer> list;

    @Before
    public void helper(){
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
    }

    @Test
    public void deduplicate() {

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate(new ListSorter(list));

        assertEquals(expected, distinct);
    }

    @Test
    public void bug8726(){
        list.clear();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        class SorterStub implements IListSorter {
            @Override
            public List<Integer> sort(){
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(2);
                list.add(4);
                return list;
            }
        }

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate(new SorterStub());

        assertEquals(expected, distinct);
    }

    /*@Test
    public void bug8726_Mockito(){
        IListDeduplicator deduplicator = Mockito.mock(IListDeduplicator.class);
        List<Integer> deduplicated = new ArrayList<>();
        deduplicated.add(1);
        deduplicated.add(2);
        deduplicated.add(4);

        Mockito.when(deduplicator.deduplicate()).thenReturn(deduplicated);

        list.clear();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);

        List<Integer> distinct = deduplicator.deduplicate();

        assertEquals(expected, distinct);

    }*/
}