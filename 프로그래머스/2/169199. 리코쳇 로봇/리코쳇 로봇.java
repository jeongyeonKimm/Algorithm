import java.util.*;

class Solution {
    
    int n, m;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    boolean[][] visited;
    
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        visited = new boolean[n][m];
        
        int startX = 0;
        int startY = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    startX = i;
                    startY = j;
                }
            }
        }
        
        return bfs(board, startX, startY);
    }
    
    private int bfs(String[] board, int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int cnt = cur.count;
            
            if (board[cur.x].charAt(cur.y) == 'G') {
                return cnt;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                while (true) {
                    if (isValid(nx, ny) && board[nx].charAt(ny) != 'D') {
                        nx += dx[i];
                        ny += dy[i];
                    } else {
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                }
                
                if (!visited[nx][ny]) {
                    queue.offer(new Node(nx, ny, cnt + 1));
                    visited[nx][ny] = true;
                }
            }
        }
        
        return -1;
    }
    
    private boolean isValid(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
    
    class Node {
        int x;
        int y;
        int count;
        
        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}