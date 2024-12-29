import java.util.*;

class Solution {
    
    private int answer = 0;
    private boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(n, computers, i);
            }
        }
        
        return answer;
    }
    
    private void dfs(int n, int[][] computers, int com) {
        if (visited[com]) return;
        
        visited[com] = true;
        
        for (int i = 0; i < n; i++) {
            if (com != i && !visited[i] && computers[com][i] == 1) {
                dfs(n, computers, i);
            }
        }
    }
}