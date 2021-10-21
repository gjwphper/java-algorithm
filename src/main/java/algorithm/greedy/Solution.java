package algorithm.greedy;

import java.util.Arrays;

public class Solution {

    /**
     * 455. 分发饼干
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
     *
     * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
     *
     *
     * 示例 1:
     *
     * 输入: g = [1,2,3], s = [1,1]
     * 输出: 1
     * 解释:
     * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
     * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
     * 所以你应该输出1。
     * 示例 2:
     *
     * 输入: g = [1,2], s = [1,2,3]
     * 输出: 2
     * 解释:
     * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
     * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
     * 所以你应该输出2.
     *
     *
     *    int[] g = {2,6};//胃口
     *    int[] s = {1,3,7};//尺寸
     *    输出2
     *
     *
     *
     *
     *
     *
     *
     * 方法一：排序 + 贪心
     * 为了尽可能满足最多数量的孩子，从贪心的角度考虑，应该按照孩子的胃口从小到大的顺序依次满足每个孩子，且对于每个孩子，应该选择可以满足这个孩子的胃口且尺寸最小的饼干。证明如下。
     * 基于上述分析，可以使用贪心的方法尽可能满足最多数量的孩子。
     *
     * 首先对数组 gg 和 ss 排序，然后从小到大遍历 gg 中的每个元素，对于每个元素找到能满足该元素的 ss 中的最小的元素。具体而言，令 ii 是 gg 的下标，jj 是 ss 的下标，初始时 ii 和 jj 都为 00，进行如下操作。
     *
     * 对于每个元素 g[i]g[i]，找到未被使用的最小的 jj 使得 g[i] \le s[j]g[i]≤s[j]，则 s[j]s[j] 可以满足 g[i]g[i]。由于 gg 和 ss 已经排好序，因此整个过程只需要对数组 gg 和 ss 各遍历一次。
     * 当两个数组之一遍历结束时，说明所有的孩子都被分配到了饼干，或者所有的饼干都已经被分配或被尝试分配（可能有些饼干无法分配给任何孩子），此时被分配到饼干的孩子数量即为可以满足的最多数量
     *
     * 复杂度分析
     *
     * 时间复杂度：O(m \log m + n \log n)O(mlogm+nlogn)，其中 mm 和 nn 分别是数组 gg 和 ss 的长度。对两个数组排序的时间复杂度是 O(m \log m + n \log n)O(mlogm+nlogn)，遍历数组的时间复杂度是 O(m+n)O(m+n)，因此总时间复杂度是 O(m \log m + n \log n)O(mlogm+nlogn)。
     *
     * 空间复杂度：O(\log m + \log n)O(logm+logn)，其中 mm 和 nn 分别是数组 gg 和 ss 的长度。空间复杂度主要是排序的额外空间开销。
     *

     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int numOfChildren = g.length, numOfCookies = s.length;
        int count = 0;
        for (int i = 0, j = 0; i < numOfChildren && j < numOfCookies; i++, j++) {
            while (j < numOfCookies && g[i] > s[j]) {
                j++;
            }
            if (j < numOfCookies) {
                count++;
            }
        }
        return count;
    }


    /**
     * 买卖股票的最佳时机 II
     * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: prices = [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * 示例 2:
     *
     * 输入: prices = [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例 3:
     *
     * 输入: prices = [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0
     *
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，其中 nn 为数组的长度。我们只需要遍历一次数组即可。
     *
     * 空间复杂度：O(1)O(1)。只需要常数空间存放若干变量。
     *
     *
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }


}