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
    public ListNode mergeKLists(ListNode[] lists) {
        int freq = 1, len = lists.length;
        
        if(len == 0)
            return null;
        
        while(freq < len){
            for(int i = 0; i + freq < len; i += freq*2){
                lists[i] = mergeList(lists[i], lists[i+freq]);
            }
            freq *= 2;    
        }
        
        return lists[0];
    }
    
    public ListNode mergeList(ListNode list1, ListNode list2){
        if(list1 == null)
            return list2;
        
        if(list2 == null)
            return list1;
        
        ListNode head = null, prev = null;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                if(head == null)
                    head = list1;
                
                if(prev == null)
                    prev = list1;
                else{
                    prev.next = list1;
                    prev = list1;
                }
                
                list1 = list1.next;
            }
            else{
                if(head == null)
                    head = list2;
                
                if(prev == null)
                    prev = list2;
                else{
                    prev.next = list2;
                    prev = list2;
                }
                
                list2 = list2.next;
            }
        }
        if(list1 != null)
            prev.next = list1;
        else
            prev.next = list2;

        return head;
    }
}