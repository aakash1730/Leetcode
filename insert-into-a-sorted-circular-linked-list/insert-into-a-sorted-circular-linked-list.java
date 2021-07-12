class Solution {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if(head == null){
            node.next = node;
            head = node;
            return head;
        }
        
        Node temp = head, temp1 = head.next;
        if(temp == temp1){
            temp.next = node;
            node.next = head;
            return head;
        }
        while(temp1 != head && temp.val <= temp1.val){
            temp = temp.next;
            temp1 = temp1.next;
        }
        
        if(insertVal >= temp.val){
            Node insertNode = new Node(insertVal, temp.next);
            temp.next = insertNode;
            return head;
        }
        while(true){
            if(insertVal <= temp.next.val){
                Node insertNode = new Node(insertVal, temp.next);
                temp.next = insertNode;
                break;
            }
            temp = temp.next;
        }
        
        return head;
    }
}