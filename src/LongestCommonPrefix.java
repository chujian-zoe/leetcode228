public class LongestCommonPrefix {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     */
    public String longestCommonPrefix(String[] strs){
        String ans = "";
        if(strs.length == 0) return ans;
        for(int i = 0; i < 200; i++){
            String s = strs[0];
            if(i >= s.length()) return ans;
            char cs = strs[0].charAt(i);
            for(String item : strs){
                if(i >= item.length() || item.charAt(i) != cs) return ans;
            }
            ans += String.valueOf(cs);
        }
        return ans;
    }
}
