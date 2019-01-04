package com.jrgurrola.precedence;

import java.util.AbstractMap;
import java.util.Comparator;

public class SimpleEntryComparator implements Comparator<AbstractMap.SimpleEntry<Integer, String>> {

    @Override
    public int compare(AbstractMap.SimpleEntry<Integer, String> se1, AbstractMap.SimpleEntry<Integer, String> se2) {
        return (se1.getKey() - se2.getKey());
    }
}
