class Node{
    Node next, prev;
    int key, value;
    
    public Node(){
        next = null;
        prev = null;
    }
    
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    Map<Integer, Node> map;
    int maxCapacity, size;
    Node head, tail;
    public LRUCache(int capacity) {
        map = new HashMap();
        maxCapacity = capacity;
        size = 0;
        head = new Node();
        tail = new Node();
        
        head.next = tail;
        tail.prev = head;        
    }
    
    public int get(int key) {
        // System.out.println("Get: " + key);
        Node node = map.get(key);
        
        if(node == null)
            return -1;
        
        removeNode(node);
        addAtHead(node);
        
        // print();
        return node.value;
    }
    
    public void put(int key, int value) {
        // System.out.println("Put: " + key);
        Node node = map.get(key);
        
        if(node == null){
            node = new Node(key, value);
            addAtHead(node);
            size++;
            
            if(size > maxCapacity){
                size--;
                map.remove(removeTailNode());
            }
            map.put(key, node);
        }
        else{
            node.value = value;
            removeNode(node);
            addAtHead(node);
        }
        
        // System.out.println(map);
        // print();
    }
    
    public int removeTailNode(){
        Node node = tail.prev;
        tail.prev = node.prev;
        node.prev.next = tail;
        
        return node.key;
    }
    
    public void addAtHead(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    public void removeNode(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    
    public void print(){
        Node temp = head.next;
        
        while(temp != tail){
            System.out.println("Key: " + temp.key + " value: " + temp.value);
            temp = temp.next;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */