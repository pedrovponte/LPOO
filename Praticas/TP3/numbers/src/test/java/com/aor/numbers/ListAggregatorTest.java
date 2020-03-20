package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListAggregatorTest {
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
    public void sum() {

        ListAggregator aggregator = new ListAggregator(list);

        int sum = aggregator.sum();

        assertEquals(14, sum);
    }

    @Test
    public void max() {

        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(5, max);
    }

    @Test
    public void bug7263(){
        list.clear();
        list.add(-1);
        list.add(-4);
        list.add(-5);

        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(-1, max);
    }

    @Test
    public void min() {

        ListAggregator aggregator = new ListAggregator(list);

        int min = aggregator.min();

        assertEquals(1, min);
    }

    @Test
    public void distinct() {

        ListAggregator aggregator = new ListAggregator(list);

        class DeduplicateStub implements IListDeduplicator{
            @Override
            public List<Integer> deduplicate(IListSorter sorter) {
                List<Integer> res = new ArrayList<>();
                res.add(1);
                res.add(2);
                res.add(4);
                res.add(5);
                return res;
            }
        }

        class SorterStub implements IListSorter{
            @Override
            public List<Integer> sort() {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(2);
                list.add(2);
                list.add(4);
                list.add(5);
                return list;
            }
        }

        int distinct = aggregator.distinct(new DeduplicateStub(), new SorterStub());

        assertEquals(4, distinct);
    }

    @Test
    public void bug8726(){
        list.clear();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        ListAggregator aggregator = new ListAggregator(list);

        class DeduplicateStub implements IListDeduplicator {
            @Override
            public List<Integer> deduplicate(IListSorter sorter){
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(2);
                list.add(4);
                return list;
            }
        }

        class SorterStub implements IListSorter {
            @Override
            public List<Integer> sort() {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(2);
                list.add(2);
                list.add(4);
                return list;
            }
        }

        int distinct = aggregator.distinct(new DeduplicateStub(), new SorterStub());

        assertEquals(3, distinct);
    }

    /*@Test
    public void bug8726_Mockito(){
        IListDeduplicator deduplicator = Mockito.mock(IListDeduplicator.class);
        List<Integer> deduplicated = new ArrayList<>();
        deduplicated.add(1);
        deduplicated.add(2);
        deduplicated.add(4);

        Mockito.when(deduplicator.deduplicate(new ListSorter(deduplicated))).thenReturn(deduplicated);

        list.clear();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct();

        assertEquals(3, distinct);
    }*/


}