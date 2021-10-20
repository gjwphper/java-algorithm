package algorithm.array;

public class Solution {

    //两次遍历
    public void moveZeroes1(int[] nums) {
        if(nums==null) {
            return;
        }
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for(int i=0;i<nums.length;++i) {
            if(nums[i]!=0) {
                nums[j++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for(int i=j;i<nums.length;++i) {
            nums[i] = 0;
        }
    }


    /**
     * 方法一：双指针
     * 思路及解法
     *
     * 使用双指针，左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
     *
     * 右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。
     *
     * 注意到以下性质：
     *
     * 左指针左边均为非零数；
     *
     * 右指针左边直到左指针处均为零。
     *
     * 因此每次交换，都是将左指针的零与右指针的非零数交换，且非零数的相对顺序并未改变。
     *
     * 代码
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int n = nums.length, slow = 0, quick = 0;
        while (quick < n) {
            if (nums[quick] != 0) {
                swap(nums, slow, quick);
                slow++;
            }
            quick++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public int[] twoSum(int[] nums,int target){

        int len = nums.length;
        int[] e = {};
        if (len < 2){
            return e;
        }
        int i = 0;
        int j = len - 1;
        while(i < j){
            if(nums[i] + nums[j] == target){
                int[] r = {i+1,j+1};
                return r;
            }else if(nums[i] + nums[j] <target){
                i += 1;
            }else{
                j -= 1;
            }
        }
        return e;
    }




    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
