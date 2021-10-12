package dataStructure.hash;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(3);
        myHashSet.add(4);
        myHashSet.add(5);

        boolean contains = myHashSet.contains(3);
        System.out.println(contains);

        myHashSet.remove(3);
        contains = myHashSet.contains(3);
        System.out.println(contains);

        MyHashSetApp myHashSetApp = new MyHashSetApp();
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(1);
        integers.add(3);
        boolean duplicates = myHashSetApp.findDuplicates(integers);
        System.out.println(duplicates);


        TreeSet treeSet = new TreeSet();
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(5);

        System.out.println(treeSet.toArray());
    }
}
