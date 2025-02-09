import java.util.Arrays;

class Solution {
    
    private int n, m;
    
    public int solution(int[][] board, int[][] skill) {
        n = board.length;
        m = board[0].length;
        
        int[][] map = new int[n + 1][m + 1];
        
        // 누적합 이용
        for (int[] s : skill) {
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5] * (s[0] == 1 ? -1 : 1);
            
            map[r1][c1] += degree;
            map[r1][c2 + 1] -= degree;
            map[r2 + 1][c1] -= degree;
            map[r2 + 1][c2 + 1] += degree;
        }
        calculatePrefixSum(map);
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] + map[i][j] <= 0) {
                    count++;
                }
            }
        }
        
        return n * m - count;
    }
    
    private void calculatePrefixSum(int[][] map) {
        // 상 -> 하 누적
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m + 1; j++) {
                map[i + 1][j] += map[i][j];
            }
        }
        
        // 좌 -> 우 누적
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j + 1] += map[i][j];
            }
        }
    }
}