
public class ReverseList {
    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     */
    public ListNode reverseList(ListNode head){
        ListNode cur = head, pre = null;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
