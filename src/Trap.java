public class Trap {
    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     */
    public int trap(int[] height){
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int preMax = 0;
        int sufMax = 0;
        while(left < right){
            preMax = Math.max(preMax, height[left]);
            sufMax = Math.max(sufMax, height[right]);
            ans += preMax < sufMax ? preMax - height[left++] : sufMax - height[right--];
        }
        return ans;
    }
}
