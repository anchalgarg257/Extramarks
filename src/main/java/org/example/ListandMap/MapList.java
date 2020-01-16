package org.example.ListandMap;

import java.util.HashMap;
import java.util.Map;

public class MapList {
    public static void main (String [] args) {

        Map<String, String> map = new HashMap<>();

        map.put("name", "Anchal");
        map.put("Address", "Delhi");

        System.out.println(map);
    }
}
