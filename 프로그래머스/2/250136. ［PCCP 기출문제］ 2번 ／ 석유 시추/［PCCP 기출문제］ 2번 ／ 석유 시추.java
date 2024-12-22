import java.util.*;

class Solution {
    
    int n, m;
    boolean[][] visited;
    int[] oil;
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        
        visited = new boolean[n][m];
        oil = new int[m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(land, i, j);
                }
            }
        }
        
        Arrays.sort(oil);
        
        return oil[m - 1];
    }
    
    private void bfs(int[][] land, int x, int y) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        Set<Integer> columns = new HashSet<>();
        Queue<Location> q = new LinkedList<>();
        q.offer(new Location(x, y));
        visited[x][y] = true;
        
        int oilQuantity = 1;
        
        while (!q.isEmpty()) {
            Location cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            columns.add(curY);
            
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if (!isValid(land, nx, ny)) {
                    continue;
                }
                
                q.offer(new Location(nx, ny));
                visited[nx][ny] = true;
                oilQuantity++;
            }
        }
        
        for (int c : columns) {
            oil[c] += oilQuantity;
        }
    }
    
    private boolean isValid(int[][] land, int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m && !visited[x][y] && land[x][y] == 1;
    }
    
    class Location {
        int x;
        int y;
        
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}