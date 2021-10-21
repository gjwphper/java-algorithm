package algorithm.greedy;

public class Test {
    public static void main(String[] args) {
        int[] g = {2,6};//胃口
        int[] s = {1,3,7};//尺寸
        Solution solution = new Solution();
        int contentChildren1 = solution.findContentChildren(g, s);
        System.out.println(contentChildren1);
    }
}
