package leetcode01;


public class SingelNumber {


    public static void main(String[] args) {

        int[] list = {1,1,2,2,3};
        Solution solution = new Solution();
        int r = solution.singleNumber(list);
        System.out.println(r);

    }


}
