public class Reverse {
    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     */
    public int reverse(int x) {
        int ans = 0;
        while(x != 0){
            if(x > 0 && ans > (Integer.MAX_VALUE - x % 10) / 10) return 0;
            if(x < 0 && ans < (Integer.MIN_VALUE - x % 10) / 10) return 0;
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        return ans;
    }
}
