import java.util.*;

class Solution {
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int[] solution(String[][] places) {
        int[] result = new int[5];
        
        for (int i = 0; i < places.length; i++) {
            char[][] room = new char[5][5];
            for (int j = 0; j < 5; j++) {
                room[j] = places[i][j].toCharArray();
            }
            
            result[i] = checkRoom(room);
        }
        
        return result;
    }
    
    private int checkRoom(char[][] room) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (room[i][j] == 'P') {
                    if (!checkDistance(room, i, j)) {
                        return 0;
                    }
                }
            }
        }
        
        return 1;
    }
    
    private boolean checkDistance(char[][] room, int x, int y) {
        boolean[][] visited = new boolean[5][5];
        Queue<Location> q = new LinkedList<>();
        q.offer(new Location(x, y));
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            Location cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if (!isInRoom(nx, ny) || visited[nx][ny]) {
                    continue;
                }
                
                int distance = Math.abs(nx - x) + Math.abs(ny - y);
                
                if (room[nx][ny] == 'P' && distance <= 2) {
                    return false;
                }
                
                if (room[nx][ny] == 'O' && distance < 2) {
                    q.offer(new Location(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        
        return true;
    }
    
    private boolean isInRoom(int x, int y) {
        return 0 <= x && x < 5 && 0 <= y && y < 5;
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