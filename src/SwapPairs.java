public class SwapPairs {
    /**
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     */
    public ListNode swapPairs(ListNode head){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for(ListNode cur = dummy; cur.next != null && cur.next.next != null;){
            ListNode a = cur.next;
            ListNode b = a.next;
            cur.next = b;
            a.next = b.next;
            b.next = a;
            cur = a;
        }
        return dummy.next;
    }
}
