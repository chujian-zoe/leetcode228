import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    private char[] path;
    private List<String> res = new ArrayList<>();
    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * 示例 1：
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     */
    public List<String> generateParenthesis(int n){
        path = new char[n * 2];
        dfs(n, 0, 0, "");
        return res;
    }

    private void dfs(int n, int lc, int rc, String str){
        if(lc == n && rc == n){
            res.add(str);
        }else{
            if(lc < n){
                dfs(n, lc + 1, rc, str + "(");
            }
            if(rc < n && lc > rc){
                dfs(n, lc, rc + 1, str + ")");
            }
        }
    }

}
