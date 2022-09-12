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
    public ListNode reverseList(ListNode head) {
        ListNode h1 = head, h2 = null, t = h1;
        
        while(h1!= null) {
            t = h1;
            h1 = h1.next;
            t.next = h2;
            h2 = t;
        }
        
        return h2;
    }
}