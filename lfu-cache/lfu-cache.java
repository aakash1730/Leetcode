class Node{
    int key, value, count;
    Node next, prev;
    
    public Node(){
        this.next = null;
        this.prev = null;
    }
    
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class DLLNode{
    Node head, tail;
    int size;
    
    public DLLNode(){
        this.size = 0;
        this.head = new Node();
        this.tail = new Node();
        
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public void addFirst(Node node){
        this.size++;
        node.next = this.head.next;
        this.head.next.prev = node;
        node.prev = this.head;
        this.head.next = node;
    }
    
    public void removeNode(Node node){
        this.size--;
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int removeLastNode(){
        this.size--;
        Node tailPrev = this.tail.prev;
        tailPrev.prev.next = this.tail;
        this.tail.prev = tailPrev.prev;
        
        return tailPrev.key;
    }
}

class LFUCache {
    int maxCapacity, size, minFreq;
    Map<Integer, Node> LRU;
    Map<Integer, DLLNode> countMap;
    
    public LFUCache(int capacity) {
        this.maxCapacity = capacity;
        this.size = 0;
        countMap = new HashMap();
        LRU = new HashMap();
        minFreq = 1;
    }
    
    public int get(int key) {
        Node node = this.LRU.get(key);
        
        if(node == null)
            return -1;
        
        this.updateMap(node);
        
        return node.value;
    }
    
    public void put(int key, int value) {
        if(this.maxCapacity == 0)
            return;
        
        Node node = this.LRU.get(key);
        
        if(node == null){
            node = new Node(key, value);
            this.size++;
            node.count = 1;
            if(this.size > this.maxCapacity){
                this.size--;
                int k = this.update(node);
                this.LRU.remove(k);
                this.countMap.get(1).addFirst(node); 
            }
            else{
                DLLNode dllNode = this.countMap.getOrDefault(1, new DLLNode());
                dllNode.addFirst(node);
                this.countMap.put(1, dllNode);    
            }
            
            this.minFreq = 1;
        }
        else{
            node.value = value;
            this.updateMap(node);
        }
        
        this.LRU.put(key, node);
    }
    
    public void updateMap(Node node){
        int oldCount = node.count;
        DLLNode ddlNode = this.countMap.get(oldCount);
        ddlNode.removeNode(node);
        
        if(ddlNode.size == 0 && node.count == this.minFreq)
            this.minFreq++;
        
        node.count++;
        int newCount = node.count;
        ddlNode = this.countMap.getOrDefault(newCount, new DLLNode());
        ddlNode.addFirst(node);   
        
        this.countMap.put(newCount, ddlNode);
    }
    
    public int update(Node node){
        DLLNode ddlNode = this.countMap.get(this.minFreq);
        int key = ddlNode.removeLastNode();
        return key;
    }
    
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */