class Solution {
    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        int count = 0;
        
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        
        for (int i = 0; i < 4; i++) {
            int hCheck = h + dh[i];
            int wCheck = w + dw[i];
            if (hCheck >= 0 && hCheck < n & wCheck >= 0 && wCheck < n) {
                if (board[h][w].equals(board[hCheck][wCheck])) {
                    count++;
                }
            }
        }
        return count;
    }
}