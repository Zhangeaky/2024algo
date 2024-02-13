package alearning.se.map;

import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapTest {

    public static void main(String[] args) {

        SortedMap<String, String> sorted = new TreeMap<>();

        sorted.put("A", "alice");
        sorted.put("B", "bob");
        sorted.put("C", "cindy");
        sorted.put("D", "Daniel");
        sorted.put("E", "emma");
        sorted.put("F", "Fans");




        System.out.println(sorted);
        sorted.get("A");

        SortedMap<String, String> bMap = sorted.headMap("B");
        System.out.println(bMap);
        System.out.println(bMap==sorted);

    }
}
