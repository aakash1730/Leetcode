class Solution {
    int WHITE = 0, GREY = 1, BLACK = 2;
    List<Integer> ans = new ArrayList();
    boolean isPossible = true;
    List<List<Integer>> adajacentMatrix = new ArrayList();
    Map<Integer, Integer> colorMap = new HashMap();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] answer = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            adajacentMatrix.add(new ArrayList<Integer>());
            colorMap.put(i, WHITE);
        }
        
        for(int[] courses : prerequisites)
            adajacentMatrix.get(courses[1]).add(courses[0]);
        
        for(int i = 0; i < numCourses; i++){
            if(!isPossible)
                break;
            if(colorMap.get(i) == WHITE)
                bfs(i);
        }
        
        if(isPossible){
            for(int i = numCourses-1; i >= 0; i--)
                answer[numCourses-i-1] = ans.get(i);
        }
        else
            answer = new int[0];
                
        return answer;
    }
    
    public void bfs(int source){
        if(!isPossible)
            return;
        
        colorMap.put(source, GREY);
        
        for(Integer neighbour : adajacentMatrix.get(source)){
            if(colorMap.get(neighbour) == WHITE){
                bfs(neighbour);
            }
            else{
                if(colorMap.get(neighbour) == GREY){
                    isPossible = false;
                }
            }
        }
        colorMap.put(source, BLACK);
        ans.add(source);
    }
}