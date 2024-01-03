public class SearchRange {
    /**
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
     * 示例 1：
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     */
    public int[] searchRange(int[] nums, int target){
        int[] ans = new int[]{-1, -1};
        int n = nums.length;
        if(n == 0){
            return ans;
        }
        int l = 0;
        int r = n - 1;
        while(l < r){
            int mid = l + r >> 1;
            if(nums[mid] >= target){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        if(nums[r] != target) return ans;
        ans[0] = r;
        l = 0;
        r = n - 1;
        while(l < r){
            int mid = l + r + 1 >> 1;
            if(nums[mid] <= target){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        ans[1] = r;
        return ans;
    }
}
