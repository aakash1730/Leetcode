class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]> (){
           @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        List<int[]> ans = new ArrayList();
        for(int[] arr : people){
            ans.add(arr[1], arr);
        }
        
        
        return ans.toArray(new int[people.length][2]);
    }
}