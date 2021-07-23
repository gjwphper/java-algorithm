package frequent;

public class ReverseString {

    public static void main(String[] args) {

        String str = "hello";
        char[] chars = str.toCharArray();
        reverseString(chars);
        System.out.println(chars);


    }

    private static void reverseString(char[] chars) {

//        int middle = 0;

//        if(chars.length % 2 == 0){
//            middle = (chars.length/2);
//        }else{
//            middle = (chars.length/2) + 1;
//        }
//
//        for (int i = 0; i < chars.length; i++) {
//            if(i < middle){
//                char tmp = chars[i];
//                chars[i] = chars[chars.length - i - 1];
//                chars[chars.length - i -1] = tmp;
//            }
//        }

        int len = chars.length;
        for (int left = 0,right = len - 1; left < right; left++,right--) {

            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;

        }
    }
}
