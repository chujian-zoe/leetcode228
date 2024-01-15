public class RemoveNthFromEnd {
    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     */
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre, end = pre;
        while(n != 0){
            start = start.next;
            n--;
        }
        while(start.next != null){
            start = start.next;
            end = end.next;
        }
        end = end.next.next;
        return pre.next;
    }
}
