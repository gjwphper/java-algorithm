package dataStructure.skipList;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class Test {
    public static void main(String[] args) {
//        ConcurrentSkipListSet concurrentSkipListSet = new ConcurrentSkipListSet();
        ConcurrentSkipListMap<String, String> stringStringConcurrentSkipListMap = new ConcurrentSkipListMap<>();
        stringStringConcurrentSkipListMap.put("a","apple");
        stringStringConcurrentSkipListMap.put("b","banana");
        System.out.println(stringStringConcurrentSkipListMap);


    }
}
