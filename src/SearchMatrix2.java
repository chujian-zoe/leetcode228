public class SearchMatrix2 {
    /**
     * 给你一个满足下述两条属性的 m x n 整数矩阵：
     * 每行中的整数从左到右按非严格递增顺序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
     */
    public boolean searchMatrix(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m * n - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int x = matrix[mid / n][mid % n];
            if(x < target){
                r = mid - 1;
            }else if(x > target){
                l = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
