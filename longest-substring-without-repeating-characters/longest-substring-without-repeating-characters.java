class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet();
        int count = 0, left = 0;
        char ch;
        for(int right = 0; right < s.length(); right++){
            ch = s.charAt(right);
            
            while(set.contains(ch)) set.remove(s.charAt(left++));
            
            set.add(ch);
            count = Math.max(count, right-left+1);
        }
        
        return count;
    }
}