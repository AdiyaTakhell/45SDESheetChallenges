package day11.intersectionOfTwoLinkedList;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pA = headA;
        ListNode pB = headB;

        // Traverse both lists. When one pointer reaches the end,
        // redirect it to the other list's head.
        // If there's an intersection, they will meet there.
        // If not, both will eventually become null.
        while (pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }

        return pA; // Either intersection node or null
    }
}
