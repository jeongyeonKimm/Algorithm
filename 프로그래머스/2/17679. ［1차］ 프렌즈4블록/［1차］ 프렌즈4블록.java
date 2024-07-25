class Solution {
    
    private char[][] map;
    
    public int solution(int m, int n, String[] board) {
        map = new char[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        
        int total = 0;
        
        while (true) {
            boolean[][] check = new boolean[m][n];
            
            checkMap(check, m, n);
            
            int count = countBlock(check, m, n);
            if (count == 0) break;
            total += count;
            
            moveMap(m, n);
        }
        
        return total;
    }
    
    private void checkMap(boolean[][] check, int m, int n) {
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (map[i][j] == map[i][j + 1] && 
                    map[i][j] == map[i + 1][j] && 
                    map[i][j] == map[i + 1][j + 1]) {
                    check[i][j] = true;
                    check[i][j + 1] = true;
                    check[i + 1][j] = true;
                    check[i + 1][j + 1] = true;
                }
            }
        }
    }
    
    private int countBlock(boolean[][] check,  int m, int n) {
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j] && map[i][j] != '-') {
                    count++;
                    map[i][j] = '-';
                }
            }
        }
        
        return count;
    }
    
    private void moveMap(int m, int n) {
        // 밑에서부터 보는 이유는 블록이 떨어지는 횟수를 줄이기 위해서
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != '-') {
                    continue;
                }
                
                for (int k = i - 1; k >= 0; k--) {
                    if (map[k][j] != '-') {
                        map[i][j] = map[k][j];
                        map[k][j] = '-';
                        break;
                    }
                }
            }
        }
    }
}