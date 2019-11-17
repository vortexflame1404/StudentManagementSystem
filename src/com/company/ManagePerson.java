package com.company;

import java.util.*;

abstract class ManagePerson {

    abstract void saveToFile();

    abstract void readFile();

    abstract void addNew();

    abstract void update();

    abstract void viewAll();

    //https://stackoverflow.com/questions/6713239/partial-search-in-hashmap
    <V> SortedMap<String, V> filterPrefix(SortedMap<String, V> baseMap, String prefix) {
        if(prefix.length() > 0) {
            char nextLetter = (char) (prefix.charAt(prefix.length() - 1) + 1);
            String end = prefix.substring(0, prefix.length()-1) + nextLetter;
            return baseMap.subMap(prefix, end);
        }
        return baseMap;
    }

    abstract void searchFor();

    abstract void delete();
}
