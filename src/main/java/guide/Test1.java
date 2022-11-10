package guide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {
        List<Integer> list = new ArrayList<>();
        //
        list.add(12);
        System.out.println(list);
        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
        //但是通过反射添加，是可以的
        add.invoke(list, "kl");
        System.out.println(list);


        Ext1<Integer> ext = new Ext1<Integer>(123456);
        Integer key = ext.getKey();
        System.out.println(key);


        String a = new String("ab"); // a 为一个引用
        String b = new String("ab"); // b为另一个引用,对象的内容一样
        Integer c = 10;

        Double i3 = 1.2;

        Double i4 = 1.2;

        System.out.println(i3.equals(i4));// 输出 false
        if(a.equals(b)){
            System.out.println(111);
        }


        StringBuffer s = new StringBuffer("aaa");
        StringBuilder z = new StringBuilder("bbb");
        System.out.println(s);


//        Scanner input = new Scanner(System.in);
//        String ww  = input.nextLine();
//        System.out.println(ww);
//        input.close();


        BufferedReader input1 = new BufferedReader(new InputStreamReader(System.in));
        String zz = input1.readLine();
        System.out.println(zz);
        input1.close();






    }
}
