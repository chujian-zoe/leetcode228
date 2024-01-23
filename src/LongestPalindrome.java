public class LongestPalindrome {
    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
     */
    public String longestPalindrome(String s) {
        String ans = "";
        for(int i = 0; i < s.length(); i++){
            int l = i - 1, r = i + 1;
            String sub = getString(s, l, r);
            if(sub.length() > ans.length()) ans = sub;
            l = i - 1;
            r = i + 1 - 1;
            sub = getString(s, l, r);
            if(sub.length() > ans.length()) ans = sub;
        }
        return ans;
    }

    String getString(String s, int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}
