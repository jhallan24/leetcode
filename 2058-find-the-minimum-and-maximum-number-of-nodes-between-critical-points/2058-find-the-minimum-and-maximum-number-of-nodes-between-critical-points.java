/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[] {-1, -1};
        }
        
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = Integer.MIN_VALUE;
        
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;
        
        int index = 1;
        int firstCriticalIndex = -1;
        int lastCriticalIndex = -1;
        int prevCriticalIndex = -1;
        
        while (next != null) {
            if ((curr.val > prev.val && curr.val > next.val) || (curr.val < prev.val && curr.val < next.val)) {
                if (firstCriticalIndex == -1) {
                    firstCriticalIndex = index;
                } else {
                    minDistance = Math.min(minDistance, index - prevCriticalIndex);
                    maxDistance = index - firstCriticalIndex;
                }
                prevCriticalIndex = index;
            }
            prev = curr;
            curr = next;
            next = next.next;
            index++;
        }
        
        if (minDistance == Integer.MAX_VALUE) {
            return new int[] {-1, -1};
        }
        
        return new int[] {minDistance, maxDistance};
    }
}