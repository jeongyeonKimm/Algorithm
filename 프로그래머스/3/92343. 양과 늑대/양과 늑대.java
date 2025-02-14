class Solution {
    
    private boolean[] visited;
    private int maxCount = 0;
    
    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        
        visited = new boolean[n];
        
        dfs(info, edges, 0, 0, 0);
        
        return maxCount;
    }
    
    private void dfs(int[] info, int[][] edges, int idx, int sheepCount, int wolfCount) {
        visited[idx] = true;
        
        if (info[idx] == 0) {
            sheepCount++;
            maxCount = Math.max(maxCount, sheepCount);
        } else {
            wolfCount++;
        }
            
        
        if (sheepCount <= wolfCount) {
            visited[idx] = false;
            return;
        }
        
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            
            if (visited[parent] && !visited[child]) {
                dfs(info, edges, child, sheepCount, wolfCount);
            }
        }
        
        visited[idx] = false;
    }
}