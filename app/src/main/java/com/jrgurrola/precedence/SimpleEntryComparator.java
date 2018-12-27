package com.jrgurrola.precedence;

import java.util.AbstractMap;
import java.util.Comparator;

public class SimpleEntryComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        AbstractMap.SimpleEntry<Integer, String> o3 = (AbstractMap.SimpleEntry<Integer, String>) o1;
        AbstractMap.SimpleEntry<Integer, String> o4 = (AbstractMap.SimpleEntry<Integer, String>) o1;
        //Note to self: Would multiplying by -1 give a Max Heap?
        return (o3.getKey() - o4.getKey());
    }
}
