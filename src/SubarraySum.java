import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
     * 子数组是数组中元素的连续非空序列。
     * 示例 1：
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     */
    public int subarraySum(int[] nums, int k){
        int len = nums.length;
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for(int i = 0; i < len; i++){
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 1; i <= len; i++){
            int t = preSum[i];
            int d = t - k;
            count += map.getOrDefault(d, 0);
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        return count;
    }
}
