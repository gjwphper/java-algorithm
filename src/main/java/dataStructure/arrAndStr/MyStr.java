package dataStructure.arrAndStr;

public class MyStr {
    //相反方向双指针
    public void reverseStr(char[] s){
        int n = s.length;
        for (int left=0,right=n-1;left<right;++left,--right){
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }


    public int quickSlow(int[] s,int a){

        int n = s.length;
        int slow = 0;
        for (int f = 0; f < n; f++) {
            if(s[f] != a){
                s[slow] = s[f];
                slow++;
            }
        }
        return slow;
    }


}
