package algorithm.binarySearch;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        T1 t1 = new T1();
        int nums[] = {-1,0,3,5,9,12};
        int i = t1.binarySearch(nums, 0);
        System.out.println(i);


        T2 t2 = new T2();
        int nums2[] = {-1,0,3,5,9,12};
        int i2 = t2.binarySearch(nums2, 0);
        System.out.println(i2);

        T3 t3 = new T3();
        int nums3[] = {-1,0,3,5,9,12};
        int i3 = t3.binarySearch(nums3, 0);
        System.out.println(i3);

    }
}
