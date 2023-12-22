public class MoveZeroes {
    /**
     *给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     */
    public void moveZeroes(int[] nums){
        int n = nums.length;
        int right = 0;
        for(int left = 0; left < n; left++){
            if(nums[left] != 0){
                swap(nums, left, right++);
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
