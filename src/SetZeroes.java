import java.util.HashSet;
import java.util.Set;

public class SetZeroes {
    /**
     * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
     */
    public void setZeroes(int[][] matrix){
        Set<Integer> rowZero = new HashSet<>();
        Set<Integer> colZero = new HashSet<>();
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == 0){
                    rowZero.add(i);
                    colZero.add(j);
                }
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(rowZero.contains(i) || colZero.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
