import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    private static final String[] map = new String[]{
           "", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    List<String> res = new ArrayList<>();
    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * 示例 1：
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     */
    public List<String> letterCombinations(String digits){
        if (digits == null || digits.isEmpty()){
            return res;
        }
        dfs(digits, new StringBuilder(), 0);
        return res;
    }

    public void dfs(String digits, StringBuilder curStr, int index){
        if(index == digits.length()){
            res.add(curStr.toString());
            return;
        }
        char c = digits.charAt(index);
        int pos = c - '0';
        String numString = map[pos];
        for(int i = 0; i < numString.length(); i++){
            curStr.append(numString.charAt(i));
            dfs(digits, curStr, index + 1);
            curStr.deleteCharAt(curStr.length() - 1);
        }
    }
}
