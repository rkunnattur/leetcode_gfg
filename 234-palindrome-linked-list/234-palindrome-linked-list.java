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
    public boolean isPalindrome(ListNode head) {
       
        if (head == null)  return true;
            
        ListNode slow = head, fast = head, rev = null;
        while (fast != null && fast.next != null){ 
            ListNode temp = rev;
            rev = slow;
            slow = slow.next;
            fast = fast.next.next;
            rev.next = temp; 
        }
        
        if (fast != null) slow = slow.next;
        
        while (rev != null) {
            if (slow.val != rev.val) return false;
            
            slow = slow.next;
            rev = rev.next;
        }
        
        return true;
    }
}