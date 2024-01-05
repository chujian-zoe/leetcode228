public class GetIntersectionNode {
    /**
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
     * 题目数据 保证 整个链式结构中不存在环。
     * 注意，函数返回结果后，链表必须 保持其原始结构 。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null){
            return null;
        }
        ListNode pA = headA, pB = headB;
        while(pA != pB){
            pA = pA == null ? pB : pA.next;
            pB = pB == null ? pA : pB.next;
        }
        return pA;
    }
}
