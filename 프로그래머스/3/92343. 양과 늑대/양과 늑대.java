class Solution {
    
    private int maxCount = 0;
    
    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        
        dfs(info, edges, new boolean[n], 0, 0, 0);
        
        return maxCount;
    }
    
    private void dfs(int[] info, int[][] edges, boolean[] visited, int idx, int sheepCount, int wolfCount) {
        visited[idx] = true;
        
        if (info[idx] == 0) {
            sheepCount++;
            if (sheepCount > maxCount) {
                maxCount = sheepCount;
            }
        } else {
            wolfCount++;
        }
            
        
        if (sheepCount <= wolfCount) {
            return;
        }
        
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            
            if (visited[parent] && !visited[child]) {
                boolean[] newVisited = visited.clone();
                dfs(info, edges, newVisited, child, sheepCount, wolfCount);
            }
        }
    }
}