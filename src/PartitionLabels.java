import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    /**
     * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
     * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
     * 返回一个表示每个字符串片段的长度的列表。
     */
    public List<Integer> partitionLabels(String s){
        List<Integer> list = new ArrayList<>();
        int[] edge = new int[26];
        char[] cs = s.toCharArray();
        for(int i = 0; i < cs.length; i++){
            edge[cs[i] - 'a'] = i;
        }
        int idx = 0;
        int last = -1;
        for(int i = 0; i < cs.length; i++){
            idx = Math.max(idx, edge[cs[i] - 'a']);
            if(i == idx){
                list.add(i - last);
                last = i;
            }
        }
        return list;
    }
}
