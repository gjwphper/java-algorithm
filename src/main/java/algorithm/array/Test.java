package algorithm.array;

public class Test {
    public static void main(String[] args) {

        int nums[] = {2,0,3,1,0,9};

        Solution solution = new Solution();
        solution.moveZeroes1(nums);

        int nums2[] = {2,0,3,1,0,9};
        solution.moveZeroes2(nums2);


        int nums3[] = {2,7,11,15};
        int[] ints = solution.twoSum(nums3, 9);


        int nums4[] = {2,3,1,2,4,3};
        int i1 = solution.minSubArrayLen(7, nums4);
        System.out.println(i1);






    }
}
