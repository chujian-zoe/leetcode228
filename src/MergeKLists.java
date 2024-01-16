public class MergeKLists {
    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return divide(lists, 0, lists.length);
    }

    /**
     * 合并[l, r)之间的所有链表
     */
    private ListNode divide(ListNode[] lists, int l, int r){
        if(r == l)return null;          // 区间不存在 返回空链表（任何链表与空链表合并为其本身）
        if(r - l == 1)return lists[l];  // 区间长度为1，直接返回链表lists[l]
        int mid = l + ((r - l) >> 1);   // 取区间中点
        // 递归合并[l, mid)和[mid, r)两个区间的合并结果
        return mergeTwoLists(divide(lists, l, mid), divide(lists, mid, r));
    }

    /**
     * 合并两个有序链表
     */
    private ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if(list1 == null)return list2;
        if(list2 == null)return list1;
        ListNode pre = new ListNode();  // 伪头节点，用于定位合并链表的头节点
        ListNode node = pre;    // 新链表当前的最后一个节点，初始为伪头节点
        int val1;   // 用于获取链表1的节点值
        int val2;   // 用于获取链表2的节点值
        // 直到两个链表都遍历完了，合并结束
        while(list1 != null || list2 != null){
            val1 = list1 == null ? Integer.MAX_VALUE : list1.val;     // 如果链表1已经遍历完，val1取最大值，保证链表2的节点被选择到
            val2 = list2 == null ? Integer.MAX_VALUE : list2.val;     // 如果链表2已经遍历完，val2取最大值，保证链表1的节点被选择到
            if(val1 < val2){
                // 链表1的节点值更小，加入到合并链表，并更新链表1指向的节点
                node.next = list1;
                list1 = list1.next;
            }else{
                // 链表2的节点值更小，加入到合并链表，并更新链表2指向的节点
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;   // 更新合并链表当前的最后一个节点指向
        }
        return pre.next;    // 伪头节点的下一个节点即为合并链表的头节点
    }
}
