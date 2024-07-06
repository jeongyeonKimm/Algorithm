import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    private boolean[][] visited;
    private int[][] distance;
    private int n, m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];
        distance = new int[n][m];
        
        bfs(maps, 0, 0);
        
        if (distance[n - 1][m - 1] == 0) return -1;
        return distance[n - 1][m - 1];
    }
    
    private void bfs(int[][] maps, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        distance[x][y] = 1;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (0 > nx || nx >= n || 0 > ny || ny >= m) continue;
                
                if (!visited[nx][ny] && maps[nx][ny] == 1) {
                    queue.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    distance[nx][ny] = distance[cur[0]][cur[1]] + 1;
                }
            }
        }
    }
}