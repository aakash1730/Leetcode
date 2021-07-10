/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean found = false;
        
        while(fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                found = true;
                break;
            }
        }
        
        if(!found)
            return null;
        
        fast = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        // System.out.println(slow.val);
        
        return slow;
    }
}