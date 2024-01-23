public class Convert {
    /**
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     * 请你实现这个将字符串进行指定行数变换的函数：
     * string convert(string s, int numRows);
     */
    public String convert(String s, int numRows) {
        int n = s.length();
        if( n == 1 || numRows == 1) return s;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            if( i == 0 || i == numRows - 1){
                int pos = i;
                int offset = 2 * (numRows - 1);
                while(pos < n){
                    sb.append(s.charAt(pos));
                    pos += offset;
                }
            }else{
                int pos1 = i, pos2 = 2 * numRows - i - 2;
                int offset = 2 * (numRows - 1);
                while(pos1 < n || pos2 < n){
                    if(pos1 < n){
                        sb.append(s.charAt(pos1));
                        pos1 += offset;
                    }
                    if(pos2 < n){
                        sb.append(s.charAt(pos2));
                        pos2 += offset;
                    }
                }
            }
        }
        return sb.toString();
    }
}
