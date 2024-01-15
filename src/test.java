public class test {
    public static void main(String[] args) {
        System.out.println("转换为 CMB 所需要的次数为：" + getNum("CMA"));
    }
    public static int getNum(String str){
        int res = 0;
        String stand = "CMB";
        res += (stand.charAt(0)-str.charAt(0)) * 26 * 26;
        res += (stand.charAt(1)-str.charAt(1)) * 26;
        res += stand.charAt(2)-str.charAt(2);
        return res;
    }
}