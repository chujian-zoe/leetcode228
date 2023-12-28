public class SearchMatrix {
    /**
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     */
    public boolean searchMatrix(int[][] matrix, int target){
        int m = matrix.length;;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            int l =0;
            int r = n - 1;
            while(l < r){
                int mid = l + r + 1 >> 1;
                if(matrix[i][mid] <= target) l = mid;
                else r = mid + 1;
            }
            if(matrix[i][r] == target) return true;
        }
        return false;
    }
}
