class TrieNode{
    Map<Character, TrieNode> map = new HashMap();
    String word = null;
}

class Solution {
    int[] rowDir = {1, 0, -1, 0};
    int[] colDir = {0, 1, 0, -1};
    int rowLen = 0, colLen = 0;
    boolean ans = false;
    public boolean exist(char[][] board, String word) {
        rowLen = board.length;
        colLen = board[0].length;
        TrieNode trie = new TrieNode();
        TrieNode node = trie;
        for(char ch : word.toCharArray()){
            node.map.computeIfAbsent(ch, x -> new TrieNode());
            node = node.map.get(ch);
        }
        node.word = word;
        // System.out.println(node.map + " " + node.word);
        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j < colLen; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[rowLen][colLen];
                    visited[i][j] = true;
                    helper(board, i, j, trie.map.get(board[i][j]), visited);
                    // System.out.println("----------------");
                    if(ans) break;
                }
                    
            }
        }
        
        return ans;
    }
    
    public void helper(char[][] board, int row, int col, TrieNode node, boolean[][] visited){
        if(node.word != null){
            ans = true;
            return;
        }
        
        for(int i = 0; i < 4; i++){
            int newRow = row + rowDir[i], newCol = col + colDir[i];
            if(isValid(newRow, newCol)){
                if(!visited[newRow][newCol] && node.map.containsKey(board[newRow][newCol])){
                    visited[newRow][newCol] = true;
                    // System.out.println(newRow + " " + newCol);
                    helper(board, newRow, newCol, node.map.get(board[newRow][newCol]), visited);
                    if(ans) break;
                    visited[newRow][newCol] = false;
                }
                
            }
        }
    }
    
    public boolean isValid(int row, int col){
        return row >= 0 && col >= 0 && row < rowLen && col < colLen; 
    }
}