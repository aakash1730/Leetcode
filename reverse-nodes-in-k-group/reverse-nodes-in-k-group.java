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
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode temp1 = head;
        ListNode temp2 = head;
        ListNode newHead = null, prevHead = null;
        while(true){
            // System.out.println("Temp2 " + temp2.val);
            count = k-1;
            while(count != 0 && temp2 != null){
                temp2 = temp2.next;
                count--;
            }
            if(prevHead == null){
                prevHead = temp1;
            }
            else{
                if(temp2 == null)
                    prevHead.next = temp1;
                else
                    prevHead.next = temp2;
                prevHead = temp1;
            }
            if(count != 0 || temp2 == null)
                break;
            
            if(newHead == null)
                newHead = temp2;
            
            ListNode temp3 = temp1, prev = null, temp4 = null;
            temp2 = temp2.next;
            while(temp3 != temp2){
                temp4 = temp3;
                temp3 = temp3.next;
                temp4.next = prev;
                prev = temp4;
            }
            
            temp1 = temp2;
            
        }
        
        return newHead;
    }
}