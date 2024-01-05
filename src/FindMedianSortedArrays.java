public class FindMedianSortedArrays {
    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     * 示例 1：
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int tot = nums1.length + nums2.length;
        if(tot % 2 == 0){
            int left = find(nums1, 0, nums2, 0, tot / 2);
            int right = find(nums1, 0, nums2, 0, tot / 2 + 1);
            return (left + right) / 2.0;
        }else{
            return find(nums1, 0, nums2, 0, tot / 2 + 1);
        }
    }

    int find(int[] n1, int i, int[] n2, int j, int k){
        if(n1.length - i > n2.length - j) return find(n2, j, n1, i, k);
        if(i >= n1.length) return n2[j + k - 1];
        if(k == 1){
            return Math.min(n1[i], n2[j]);
        }else{
            int si = Math.min(i + (k / 2), n1.length), sj = j + k - (k / 2);
            if(n1[si - 1] > n2[sj - 1]){
                return find(n1, i, n2, sj, k - (sj - j));
            }else{
                return find(n1, si, n2, j, k - (si - i));
            }
        }
    }
}
