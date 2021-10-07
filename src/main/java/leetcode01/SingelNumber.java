package leetcode01;


public class SingelNumber {


    public static void main(String[] args) {

        int[] list = {1,1,2,2,3};
        Solution solution = new Solution();
        System.out.println(0);
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(111);
        int r = solution.singleNumber(list);
        System.out.println(r);


    }


}
