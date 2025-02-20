class Solution {
    int MOD = 20170805;
    
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] paths = new int[m + 1][n + 1][2];
        paths[1][1][0] = 1;
        paths[1][1][1] = 1;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (cityMap[i - 1][j - 1] == 0) {
                    paths[i][j][0] += (paths[i - 1][j][0] + paths[i][j - 1][1]) % MOD;
                    paths[i][j][1] += (paths[i - 1][j][0] + paths[i][j - 1][1]) % MOD;
                } else if (cityMap[i - 1][j - 1] == 1) {
                    paths[i][j][0] = 0;
                    paths[i][j][1] = 0;
                } else {
                    paths[i][j][0] = paths[i - 1][j][0];
                    paths[i][j][1] = paths[i][j - 1][1];
                }
            }
        }
        
        return paths[m][n][0];
    }
}