package dataStructure.arrAndStr;

public class Test {
    public static void main(String[] args) {
        // initialize
        String s1 = "Hello World";
        System.out.println("s1 is \"" + s1 + "\"");
        String s2 = s1;
        System.out.println("s2 is another reference to s1.");
        String s3 = new String(s1);
        System.out.println("s3 is a copy of s1.");
        // compare using '=='
        System.out.println("Compared by '==':");
        // true since string is immutable and s1 is binded to "Hello World"
        System.out.println("s1 and \"Hello World\": " + (s1 == "Hello World"));
        // true since s1 and s2 is the reference of the same object
        System.out.println("s1 and s2: " + (s1 == s2));
        // false since s3 is refered to another new object
        System.out.println("s1 and s3: " + (s1 == s3));
        // compare using 'equals'
        System.out.println("Compared by 'equals':");
        System.out.println("s1 and \"Hello World\": " + s1.equals("Hello World"));
        System.out.println("s1 and s2: " + s1.equals(s2));
        System.out.println("s1 and s3: " + s1.equals(s3));
        // compare using 'compareTo'
        System.out.println("Compared by 'compareTo':");
        System.out.println("s1 and \"Hello World\": " + (s1.compareTo("Hello World") == 0));
        System.out.println("s1 and s2: " + (s1.compareTo(s2) == 0));
        System.out.println("s1 and s3: " + (s1.compareTo(s3) == 0));

        //https://blog.csdn.net/csxypr/article/details/92378336
        //String类是不可变类，即一旦一个String对象被创建以后，包含在这个对象中的字符序列是不可改变的，直至这个对象被销毁。


//        String s6 = "Hello World";
//        s6[5] = ',';
//        System.out.println(s1);




        String s = "";
        int n = 100;
        for (int i = 0; i < n; i++) {
            s += "hello";
            System.out.println(s);
        }

        String s9 = "gjw";
        char[] chars = s9.toCharArray();
        MyStr myStr = new MyStr();
        myStr.reverseStr(chars);
        char [] revChars = chars;
        System.out.println(chars.toString());


        int[] w = {3,5,7,9,2,7,1,7};
        int i = myStr.quickSlow(w, 7);
        for (int j = 0; j < i; j++) {
            System.out.println(w[j]);
        }


    }



}
