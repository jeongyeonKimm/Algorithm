import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    public int[] dx = {0, 0, -1, 1};
    public int[] dy = {-1, 1, 0, 0};
    
    public int solution(String[] maps) {
        int startX = 0;
        int startY = 0;
        int leverX = 0;
        int leverY = 0;
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                }
                
                if (maps[i].charAt(j) == 'L') {
                    leverX = i;
                    leverY = j;
                }
            }
        }
        
        int lCount = bfs(maps, startX, startY, 'L');
        int eCount = bfs(maps, leverX, leverY, 'E');
        
        if (lCount == -1 || eCount == -1) {
            return -1;
        }
        return lCount + eCount;
    }
    
    public int bfs(String[] maps, int startX, int startY, char target) {        
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(startX, startY, 0));
        visited[startX][startY] = true;
        
        while (!queue.isEmpty()) {
            Position cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            int count = cur.count;
            
            if (maps[x].charAt(y) == target) {
                return count;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length()) {
                    continue;
                }
                
                if (visited[nx][ny]) {
                    continue;
                }
                
                if (maps[nx].charAt(ny) != 'X') {
                    queue.offer(new Position(nx, ny, count + 1));
                    visited[nx][ny] = true;
                }
            }
        }
        
        return -1;
    }
    
    class Position {
        
        int x;
        int y;
        int count;
        
        public Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}