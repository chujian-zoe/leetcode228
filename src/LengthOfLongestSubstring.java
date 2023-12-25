import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     * 示例 1:
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */
    public int lengthOfLongestSubstring(String s){
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = -1;
        for(int right = 0; right < s.length(); right++){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right)), left);
            }
            map.put(s.charAt(right), right);
            res = Math.max(res, right - left);
        }
        return res;
    }
}
