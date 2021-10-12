package dataStructure.hash;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyHashSetApp {
    boolean findDuplicates(List<Integer> keys) {
        // Replace Type with actual type of your key
        Set<Integer> hashSets = new HashSet<Integer>();
        for (int key : keys) {
            if (hashSets.contains(key)) {
                return true;
            }
            hashSets.add(key);
        }
        return false;
    }
}
