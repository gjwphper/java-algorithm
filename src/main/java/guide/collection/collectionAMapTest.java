package guide.collection;

import java.util.*;

public class collectionAMapTest {
    public static void main(String[] args) {
        TreeMap<String, Integer> stringIntegerTreeMap = new TreeMap<>();
        stringIntegerTreeMap.put("a",3);
        stringIntegerTreeMap.put("b",4);
        stringIntegerTreeMap.put("c",5);
        System.out.println(stringIntegerTreeMap);

        LinkedList<String> strings = new LinkedList<>();
        strings.add("aa");
        strings.add("bb");
        strings.add("cc");
        String s1 = strings.get(0);
        System.out.println(s1);

        System.out.println(strings);

        Vector<String> strings1 = new Vector<>();
        strings1.add("aa");
        strings1.add("bb");
        strings1.add("cc");

        String s = strings1.get(0);
        System.out.println(s);

        System.out.println(strings1);


        ArrayList<String> strings2 = new ArrayList<>();
        strings2.add("aa");
        strings2.add("bb");
        strings2.add("cc");
        String s2 = strings.get(0);
        System.out.println(s2);

        System.out.println(strings2);




        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);
        System.out.println("原始数组:");
        System.out.println(arrayList);
        // void reverse(List list)：反转
        Collections.reverse(arrayList);
        System.out.println("Collections.reverse(arrayList):");
        System.out.println(arrayList);

        // void sort(List list),按自然排序的升序排序
        Collections.sort(arrayList);
        System.out.println("Collections.sort(arrayList):");
        System.out.println(arrayList);
        // 定制排序的用法
        Collections.sort(arrayList, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("定制排序后：");
        System.out.println(arrayList);


        long a = 1 << 30;
        System.out.println(a);
        double pow = Math.pow(2, 30);

        System.out.println(pow);


        HashSet<String> strings3 = new HashSet<>();

        String s4 = "gjw";


    }
}
