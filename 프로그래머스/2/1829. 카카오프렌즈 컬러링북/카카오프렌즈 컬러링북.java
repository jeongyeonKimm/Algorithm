class Solution {
    
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    private int count = 0;
    
    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[m][n];
        int maxSize = 0;
        int areaCount = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                
                areaCount++;
                count = 0;
                dfs(m, n, picture, visited, i, j);
                maxSize = Math.max(maxSize, count);
            }
        }
        
        return new int[] {areaCount, maxSize};
    }
    
    private void dfs(int m, int n, int[][] picture, boolean[][] visited, int x, int y) {
        if (visited[x][y]) return;
        
        visited[x][y] = true;
        count++;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            
            if (picture[x][y] == picture[nx][ny] && !visited[nx][ny]) {
                dfs(m, n, picture, visited, nx, ny);
            }
        }
    }
    
    class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}