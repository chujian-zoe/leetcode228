import java.util.ArrayList;
import java.util.List;

public class Permute {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * 示例 1：
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */
    public List<List<Integer>> permute(int[] nums){
        dfs(nums, 0, new boolean[nums.length]);
        return res;
    }

    public void dfs(int[] nums, int index, boolean[] isUsed){
        if(index == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!isUsed[i]){
                path.add(nums[i]);
                isUsed[i] = true;
                dfs(nums, index + 1, isUsed);
                isUsed[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
