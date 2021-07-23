/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */

package frequent;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(nums);//[I@1b6d3586
        System.out.println(lists);

        for (int i = 0; i < lists.size(); i++) {
            System.out.println("===========第" + "层=========");
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.println(lists.get(i).get(j));
            }
        }


    }

    public static List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}

/**
 *
 * 📖 文字题解
 * 前言
 * 本题与 1. 两数之和 类似，是非常经典的面试题，但是做法不尽相同。
 *
 * 方法一：排序 + 双指针
 * 题目中要求找到所有「不重复」且和为 00 的三元组，这个「不重复」的要求使得我们无法简单地使用三重循环枚举所有的三元组。这是因为在最坏的情况下，数组中的元素全部为 00，即
 *
 *
 * [0, 0, 0, 0, 0, ..., 0, 0, 0]
 * 任意一个三元组的和都为 00。如果我们直接使用三重循环枚举三元组，会得到 O(N^3)O(N
 * 3
 *  ) 个满足题目要求的三元组（其中 NN 是数组的长度）时间复杂度至少为 O(N^3)O(N
 * 3
 *  )。在这之后，我们还需要使用哈希表进行去重操作，得到不包含重复三元组的最终答案，又消耗了大量的空间。这个做法的时间复杂度和空间复杂度都很高，因此我们要换一种思路来考虑这个问题。
 *
 * 「不重复」的本质是什么？我们保持三重循环的大框架不变，只需要保证：
 *
 * 第二重循环枚举到的元素不小于当前第一重循环枚举到的元素；
 *
 * 第三重循环枚举到的元素不小于当前第二重循环枚举到的元素。
 *
 * 也就是说，我们枚举的三元组 (a, b, c)(a,b,c) 满足 a \leq b \leq ca≤b≤c，保证了只有 (a, b, c)(a,b,c) 这个顺序会被枚举到，而 (b, a, c)(b,a,c)、(c, b, a)(c,b,a) 等等这些不会，这样就减少了重复。要实现这一点，我们可以将数组中的元素从小到大进行排序，随后使用普通的三重循环就可以满足上面的要求。
 *
 * 同时，对于每一重循环而言，相邻两次枚举的元素不能相同，否则也会造成重复。举个例子，如果排完序的数组为
 *
 *
 * [0, 1, 2, 2, 2, 3]
 *  ^  ^  ^
 * 我们使用三重循环枚举到的第一个三元组为 (0, 1, 2)(0,1,2)，如果第三重循环继续枚举下一个元素，那么仍然是三元组 (0, 1, 2)(0,1,2)，产生了重复。因此我们需要将第三重循环「跳到」下一个不相同的元素，即数组中的最后一个元素 33，枚举三元组 (0, 1, 3)(0,1,3)。
 *
 * 下面给出了改进的方法的伪代码实现：
 *
 *
 * nums.sort()
 * for first = 0 .. n-1
 *     // 只有和上一次枚举的元素不相同，我们才会进行枚举
 *     if first == 0 or nums[first] != nums[first-1] then
 *         for second = first+1 .. n-1
 *             if second == first+1 or nums[second] != nums[second-1] then
 *                 for third = second+1 .. n-1
 *                     if third == second+1 or nums[third] != nums[third-1] then
 *                         // 判断是否有 a+b+c==0
 *                         check(first, second, third)
 * 这种方法的时间复杂度仍然为 O(N^3)O(N
 * 3
 *  )，毕竟我们还是没有跳出三重循环的大框架。然而它是很容易继续优化的，可以发现，如果我们固定了前两重循环枚举到的元素 aa 和 bb，那么只有唯一的 cc 满足 a+b+c=0a+b+c=0。当第二重循环往后枚举一个元素 b'b
 * ′
 *   时，由于 b' > bb
 * ′
 *  >b，那么满足 a+b'+c'=0a+b
 * ′
 *  +c
 * ′
 *  =0 的 c'c
 * ′
 *   一定有 c' < cc
 * ′
 *  <c，即 c'c
 * ′
 *   在数组中一定出现在 cc 的左侧。也就是说，我们可以从小到大枚举 bb，同时从大到小枚举 cc，即第二重循环和第三重循环实际上是并列的关系。
 *
 * 有了这样的发现，我们就可以保持第二重循环不变，而将第三重循环变成一个从数组最右端开始向左移动的指针，从而得到下面的伪代码：
 *
 *
 * nums.sort()
 * for first = 0 .. n-1
 *     if first == 0 or nums[first] != nums[first-1] then
 *         // 第三重循环对应的指针
 *         third = n-1
 *         for second = first+1 .. n-1
 *             if second == first+1 or nums[second] != nums[second-1] then
 *                 // 向左移动指针，直到 a+b+c 不大于 0
 *                 while nums[first]+nums[second]+nums[third] > 0
 *                     third = third-1
 *                 // 判断是否有 a+b+c==0
 *                 check(first, second, third)
 * 这个方法就是我们常说的「双指针」，当我们需要枚举数组中的两个元素时，如果我们发现随着第一个元素的递增，第二个元素是递减的，那么就可以使用双指针的方法，将枚举的时间复杂度从 O(N^2)O(N
 * 2
 *  ) 减少至 O(N)O(N)。为什么是 O(N)O(N) 呢？这是因为在枚举的过程每一步中，「左指针」会向右移动一个位置（也就是题目中的 bb），而「右指针」会向左移动若干个位置，这个与数组的元素有关，但我们知道它一共会移动的位置数为 O(N)O(N)，均摊下来，每次也向左移动一个位置，因此时间复杂度为 O(N)O(N)。
 *
 * 注意到我们的伪代码中还有第一重循环，时间复杂度为 O(N)O(N)，因此枚举的总时间复杂度为 O(N^2)O(N
 * 2
 *  )。由于排序的时间复杂度为 O(N \log N)O(NlogN)，在渐进意义下小于前者，因此算法的总时间复杂度为 O(N^2)O(N
 * 2
 *  )。
 *
 * 上述的伪代码中还有一些细节需要补充，例如我们需要保持左指针一直在右指针的左侧（即满足 b \leq cb≤c），具体可以参考下面的代码，均给出了详细的注释。
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/3sum/solution/san-shu-zhi-he-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
