class Solution {
    
    private static final int INF = (int) (1e9);
    
    public int solution(int n, int[][] results) {
        // n명의 선수가 있을 때 각 선수는 n-1개의 승패를 알아야 순위를 확정지을 수 있음
        
        int[][] graph = new int[n + 1][n + 1];
        
        for (int i = 0; i < results.length; i++) {
            int A = results[i][0];
            int B = results[i][1];
            graph[A][B] = 1;
            graph[B][A] = -1;
        }
        
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }
                    
                    if (graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
        }
        
        int answer = 0;
        
        for (int i = 1; i < n + 1; i++) {
            int count = 0;
            for (int j = 1; j < n + 1; j++) {
                if (graph[i][j] != 0) count++;
            }
            
            if (count == n - 1) answer++;
        }
        
        return answer;
    }
}