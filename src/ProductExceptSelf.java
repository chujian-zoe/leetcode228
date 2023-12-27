public class ProductExceptSelf {
    /**
     * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
     * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
     * 示例 1:
     * 输入: nums = [1,2,3,4]
     * 输出: [24,12,8,6]
     */
    public int[] productExceptSelf(int[] nums){
        int n = nums.length;;
        int[] res = new int[n];
        for(int i = 1, j = 1; i <= n; i++){
            res[i - 1] = j;
            j *= nums[i - 1];
        }
        for(int i = n, j = 1; i > 0; i--){
            res[i - 1] = j;
            j *= nums[i - 1];
        }
        return res;
    }
}
