package dataStructure.hash;

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

    }
}
