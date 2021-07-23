int[] nums = {2, 3, 5, 6, 4, 1};
Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
if (hashtable.containsKey(target - nums[i])) {
    return new int[]{hashtable.get(target - nums[i]), i};
}
return new int[0];



List<List<Integer>> lists = threeSum(nums);

List<List<Integer>> ans = new ArrayList<List<Integer>>();
int target = -nums[first];

退出条件

// 需要保证 b 的指针在 c 的指针的左侧
while (second < third && nums[second] + nums[third] > target) {
    --third;
}
// 如果指针重合，随着 b 后续的增加
// 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
if (second == third) {
    break;
}



String str = "hello";
char[] chars = str.toCharArray();

for (int left = 0,right = len - 1; left < right; left++,right--) {

            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;

}

