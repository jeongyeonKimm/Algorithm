import java.util.*;

class Solution {
    
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, 1, 0, -1};
    private int minCost = Integer.MAX_VALUE;
    private int n;
    private boolean[][][] visited;
    
    public int solution(int[][] board) {
        n = board.length;
        visited = new boolean[n][n][4];
        
        bfs(board);
        
        return minCost;
    }
    
    private void bfs(int[][] board) {
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(0, 0, 0, -1));
        
        while (!q.isEmpty()) {
            Position cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            int curCost = cur.cost;
            int curDir = cur.direction;
            
            if (curX == n - 1 && cur.y == n - 1) {
                minCost = Math.min(minCost, cur.cost);
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) {
                    continue;
                }
                
                int newCost = curCost;
                if (curDir == -1 || curDir == i) {
                    newCost += 100;
                } else {
                    newCost += 600;
                }
                
                if (!visited[nx][ny][i] || newCost <= board[nx][ny]) {
                    q.offer(new Position(nx, ny, newCost, i));
                    visited[nx][ny][i] = true;
                    board[nx][ny] = newCost;
                }
            }
        }
    }
    
    private boolean isCorner(int curDir, int nDir) {
        if ((curDir % 2 == 0 && nDir % 2 != 0)
           || (curDir % 2 != 0 && nDir % 2 == 0)) {
            return true;
        }
        return false;
    }
    
    class Position {
        int x;
        int y;
        int cost;
        int direction;
        
        public Position(int x, int y, int cost, int direction) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.direction = direction;
        }
    }
}