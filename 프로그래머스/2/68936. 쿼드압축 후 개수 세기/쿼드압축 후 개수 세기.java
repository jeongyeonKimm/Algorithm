class Solution {
    
    private int[] result = new int[2];
    
    public int[] solution(int[][] arr) {
        checkQuad(arr, 0, 0, arr.length);
        
        return result;
    }
    
    private void checkQuad(int[][] arr, int x, int y, int n) {
        if (zip(arr, x, y, n, arr[x][y])) {
            if (arr[x][y] == 0) {
                result[0]++;
            } else {
                result[1]++;
            }
            return;
        }
        
        checkQuad(arr, x, y, n / 2);
        checkQuad(arr, x, y + n / 2, n / 2);
        checkQuad(arr, x + n / 2, y, n / 2);
        checkQuad(arr, x + n / 2, y + n / 2, n / 2);
    }
    
    private boolean zip(int[][] arr, int x, int y, int n, int num) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (arr[i][j] != num) {
                    return false;
                }
            }
        }
        
        return true;
    }
}