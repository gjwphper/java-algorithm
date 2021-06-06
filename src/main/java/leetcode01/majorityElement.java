package leetcode01;

public class majorityElement {
    public static void main(String[] args) {

        int[] list = {2,2,1,1,1,2,2,2,1,1,1,1,1};
        Solution solution = new Solution();
        int r = solution.majorityElement(list);
        System.out.println(r);

    }
}
