import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * 注意：
     * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
     * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
     * 示例 1：
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
     */
    public String minWindow(String s, String t){
        Map<Character, Integer> hs = new HashMap<>();
        Map<Character, Integer> ht = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            ht.put(t.charAt(i), ht.getOrDefault(t.charAt(i), 0) + 1);
        }
        String ans = "";
        int len = Integer.MAX_VALUE;
        int cnt = 0;
        for(int i = 0, j = 0; i < s.length(); i++){
            hs.put(s.charAt(i), hs.getOrDefault(s.charAt(i), 0) + 1);
            if(ht.containsKey(s.charAt(i)) && hs.get(s.charAt(i)) <= ht.get(s.charAt(i))) cnt++;
            while(j < i && (!ht.containsKey(s.charAt(j)) || hs.get(s.charAt(j)) > ht.get(s.charAt(j)))){
                int count = hs.get(s.charAt(j)) - 1;
                hs.put(s.charAt(j), count);
                j++;
            }
            if(cnt == t.length() && i - j + 1 < len){
                len = i - j + 1;
                ans = s.substring(j, i + 1);
            }
        }
        return ans;
    }

    public String minWindow2(String s, String t){
        int n = s.length(), tot = 0;
        int[] c1 = new int[60], c2 = new int[60];
        for(char c : t.toCharArray()){
            if(++c1[getIdx(c)] == 1) tot++;
        }
        String ans = "";
        int j = 0;
        for(int i = 0; i < n; i++){
            int idx1 = getIdx(s.charAt(i));
            if(++c2[idx1] == c1[idx1]) tot--;
            while(j < i){
                int idx2 = getIdx(s.charAt(j));
                if(c2[idx2] > c1[idx2] && --c2[idx2] >= 0) j++;
                else break;
            }
            if(tot == 0 && (ans.length() == 0 || ans.length() > i - j + 1)){
                ans = s.substring(j, i + 1);
            }
        }
        return ans;
    }

    int getIdx(char x){
        return x >= 'A' && x <= 'Z' ? x - 'A' + 26 : x - 'a';
    }
}
