package org.example.ListandMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintListandMap {
    public static void main(String[] args) {
        List<Map<Integer, String>> list = new ArrayList<>();

        Map<Integer, String> person = new HashMap<>();

        person.put(1, "Anchal");
        person.put(2, "Shivani");

        list.add(person);

        System.out.println(list);
    }
}
