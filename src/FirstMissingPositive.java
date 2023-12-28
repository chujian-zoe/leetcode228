public class FirstMissingPositive {
    /**
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
     * 示例 1：
     * 输入：nums = [1,2,0]
     * 输出：3
     */
    public int firstMissingPositive(int[] nums){
        int n = nums.length;
        for(int i = 0; i < n; i++){
            while(nums[i] >= 1 && nums[i] <= n && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]= temp;
    }
}
