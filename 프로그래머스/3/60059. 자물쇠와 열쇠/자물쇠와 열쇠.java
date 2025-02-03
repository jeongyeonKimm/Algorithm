class Solution {
    
    private int n, m;
    
    public boolean solution(int[][] key, int[][] lock) {
        n = lock.length;
        m = key.length;
        
        for (int i = 0; i < n + m - 1; i++) {
            for (int j = 0; j < n + m - 1; j++) {
                for (int k = 0; k < 4; k++) {
                    int[][] expandedLock = new int[n + 2 * (m - 1)][n + 2 * (m - 1)];
                    initLock(expandedLock, lock);
                    checkLock(expandedLock, key, k, i, j);
                    if (isValid(expandedLock, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private void initLock(int[][] expandedLock, int[][] lock) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                expandedLock[m - 1 + i][m - 1 + j] = lock[i][j];
            }
        }
    }
    
    private void checkLock(int[][] expandedLock, int[][] key, int turn, int x, int y) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (turn == 0) {
                    expandedLock[x + i][y + j] += key[i][j];
                } else if (turn == 1) {
                    expandedLock[x + i][y + j] += key[m - 1 - j][i];
                } else if (turn == 2) {
                    expandedLock[x + i][y + j] += key[m - 1 - i][m - 1 - j];
                } else if (turn == 3) {
                    expandedLock[x + i][y + j] += key[j][m - 1 - i];
                }
            }
        }
    }
    
    private boolean isValid(int[][] expandedLock, int x, int y) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (expandedLock[m - 1 + i][m - 1 + j] != 1) return false;
            }
        }
        return true;
    }
}