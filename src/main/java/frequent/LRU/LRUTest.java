package frequent.LRU;

public class LRUTest {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));

        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));

        System.out.println("=====================");
        MyLinkedHashMap myLinkedHashMap = new MyLinkedHashMap(2);

        myLinkedHashMap.put(1,1);
        myLinkedHashMap.put(2,2);
        System.out.println(myLinkedHashMap.get(1));
        myLinkedHashMap.put(3,3);
        System.out.println(myLinkedHashMap.get(2));
        myLinkedHashMap.put(4,4);
        System.out.println(myLinkedHashMap.get(1));

        System.out.println(myLinkedHashMap.get(3));
        System.out.println(myLinkedHashMap.get(4));

    }
}
