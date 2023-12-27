public class MaxSubArray {
    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 子数组 是数组中的一个连续部分。
     */
    public int maxSubArray(int[] nums){
        int pre = 0;
        int res = nums[0];
        for(int num : nums){
            pre = Math.max(pre + num, num);
            res = Math.max(res, pre);
        }
        return res;
    }

}
