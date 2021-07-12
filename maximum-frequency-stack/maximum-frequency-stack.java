class FreqStack {
    int maxFreq;
    Map<Integer, Integer> freqMap;
    Map<Integer, Stack<Integer>> stackMap;
    public FreqStack() {
        maxFreq = 0;
        freqMap = new HashMap();
        stackMap = new HashMap();
    }
    
    public void push(int val) {
        freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        int fre = freqMap.get(val);
        if(maxFreq < fre)
            maxFreq = fre;
        
        stackMap.computeIfAbsent(fre, x -> new Stack<Integer>()).push(val);
    }
    
    public int pop() {
        Stack<Integer> st = stackMap.get(maxFreq);
        int ele = st.pop();
        
        if(st.size() == 0){
            stackMap.remove(maxFreq);
            maxFreq--;
        }
        
        int fre = freqMap.get(ele)-1;
        if(fre == 0)
            freqMap.remove(ele);
        else
            freqMap.put(ele, fre);
        
        return ele;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */