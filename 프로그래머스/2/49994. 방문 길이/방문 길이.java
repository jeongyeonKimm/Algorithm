class Solution {
    public int solution(String dirs) {
        boolean visited[][][] = new boolean[11][11][4];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        int x = 5;
        int y = 5;
        int count = 0;
        
        for (int i = 0; i < dirs.length(); i++) {
            char d = dirs.charAt(i);
            int idx = 0;
            if (d == 'U') {
                idx = 0;
            } else if (d == 'D') {
                idx = 1;
            } else if (d == 'R') {
                idx = 2;
            } else if (d == 'L') {
                idx = 3;
            }
            
            int nx = x + dx[idx];
            int ny = y + dy[idx];
            
            if (nx < 0 || nx >= 11 || ny < 0 || ny >= 11) {
                continue;
            }
            
            if (!visited[nx][ny][idx]) {
                visited[nx][ny][idx] = true;
                idx = (idx % 2 == 0) ? idx + 1 : idx - 1;
                visited[x][y][idx] = true;
                count++;
            }
            
            x = nx;
            y = ny;
        }
        
        return count;
    }
}