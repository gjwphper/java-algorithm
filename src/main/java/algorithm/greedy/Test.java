package algorithm.greedy;

public class Test {
    public static void main(String[] args) {

        //============分发饼干=============
        int[] g = {2,6};//胃口
        int[] s = {1,3,7};//尺寸
        Solution solution = new Solution();
        int contentChildren1 = solution.findContentChildren(g, s);
        System.out.println(contentChildren1);


        //============买卖股票的最佳时机=============
        int[] prices = {7,1,5,3,6,4};
        int i = solution.maxProfit(prices);
        System.out.println(i);


    }
}
