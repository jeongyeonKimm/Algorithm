import java.util.*;

class Solution {
    
    private int n, m;
    private char[][] containers;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        containers = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                containers[i][j] = storage[i].charAt(j);
            }
        }
    
        for (String request : requests) {
            char target = request.charAt(0);
            int len = request.length();
            
            if (len == 1) {
                accessByFolklift(target);    
            } else {
                accessByCrane(target);
            }
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (containers[i][j] != 0) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void accessByCrane(char target) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (containers[i][j] == target) {
                    containers[i][j] = 0;
                }
            }
        } 
    }
    
    private void accessByFolklift(char target) {
        boolean[][] visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) && !visited[i][j]) {   // 외부와 맞닿아 있는 외곽을 먼저 처리
                    dfs(i, j, target, visited);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (containers[i][j] == 1) {
                    containers[i][j] = 0;
                }
            }
        }
    }
    
    private void dfs(int x, int y, char target, boolean[][] visited) {
        if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y]) {
            return;
            
        }
        
        visited[x][y] = true;
        
        if (containers[x][y] == target) {
            containers[x][y] = 1;
            return;
        }
        
        if (containers[x][y] != 0) {
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(nx, ny, target, visited);
        }
    }
}