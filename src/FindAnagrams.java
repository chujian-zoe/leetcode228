import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    /**
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
     * 示例 1:
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
     */
    public List<Integer> findAnagrams(String s, String p){
        List<Integer> res = new ArrayList<>();
        int n = s.length(), m = p.length();
        if(n < m){
            return res;
        }
        int[] pCnt = new int[26];
        int[] sCnt = new int[26];
        for(int i = 0; i < m; i++){
            pCnt[p.charAt(i) - 'a']++;
        }
        int left = 0;
        for(int right = 0; right < n; right++){
            sCnt[s.charAt(right) - 'a']++;
            if(right - left + 1 > m) sCnt[s.charAt(left++) - 'a']--;
            if(check(pCnt, sCnt)){
                res.add(left);
            }
        }
        return res;
    }

    boolean check(int[] a1, int[] a2){
        for(int i = 0; i < 26; i++){
            if(a1[i] != a2[i]) return false;
        }
        return true;
    }
}
