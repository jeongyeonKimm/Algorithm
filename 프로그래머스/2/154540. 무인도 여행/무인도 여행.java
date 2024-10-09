import java.util.*;

class Solution {
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    boolean[][] visited;
    int rows, cols;

    public int[] solution(String[] maps) {
        rows = maps.length;
        cols = maps[0].length();
        
        char[][] map = new char[rows][cols];
        
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        visited = new boolean[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && map[i][j] != 'X') {
                    result.add(bfs(map, i, j));
                }
            }
        }
        
        Collections.sort(result);
        
        if (result.size() == 0) {
            return new int[] {-1};
        }
        return result.stream()
            .mapToInt(i -> i)
            .toArray();
    }   
    
    int bfs(char[][] map, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        
        int sum = 0;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            
            sum += map[curX][curY] - '0';
            
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if (nx < 0 || nx >= rows || ny < 0 || ny >= cols) {
                    continue;
                }
                
                if (visited[nx][ny]) {
                    continue;
                }
                
                if (map[nx][ny] != 'X') {
                    queue.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return sum;
    }
}