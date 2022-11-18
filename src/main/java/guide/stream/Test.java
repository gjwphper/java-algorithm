package guide.stream;

import java.util.ArrayList;
import java.util.function.BinaryOperator;

public class Test {


    public static void main(final String... args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(30);
        list.add(20);
        list.add(10);


        // reduce 需要传入一个BinaryOperator接口，继承了BiFunction接口
        // 简单说  就是需要传入2个同类型参数，返回同类型的参数
        // 预定义一下减法函数式
        BinaryOperator<Integer> add = (n1, n2) -> n1+n2;
        BinaryOperator<Integer> minus = (n1, n2) -> n1-n2;
        list.stream().reduce(add).ifPresent(n-> System.out.println(n));     // 加法
        Integer ww = list.stream().reduce(add).orElse(5656);
        System.out.println(ww);

        list.stream().reduce(minus).ifPresent(n-> System.out.println(n));     // 减法

        // 未预定义，直接写函数式
        list.stream().reduce((a,b)->a*b).ifPresent(n-> System.out.println(n));     // 乘法
    }
}

