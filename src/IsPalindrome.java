public class IsPalindrome {
    /**
     * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
     */
    public boolean isPalindrome(ListNode head){
        if(head == null || head.next == null) return true;
        ListNode pre = null;
        ListNode slow = head, fast = head;
        ListNode tmp = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            tmp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = tmp;
        }
        if(fast != null) slow = slow.next;
        boolean isPal = true;
        while(pre != null){
            if(pre.val != slow.val) isPal = false;
            slow = slow.next;
            ListNode next = pre.next;
            pre.next = tmp;
            tmp = pre;
            pre = next;
        }
        return isPal;
    }
}
