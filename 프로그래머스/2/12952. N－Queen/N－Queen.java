class Solution {
    
    private int[] board;
    private int result = 0;
    
    public int solution(int n) {
        board = new int[n];
        
        backtracking(0, n);
        
        return result;
    }
    
    private void backtracking(int col, int n) {
        if (col == n) {
            result++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            board[col] = i;
            
            if (isPossible(col, n)) {
                backtracking(col + 1, n);
            }
        }
    }
    
    private boolean isPossible(int col, int n) {
        for (int i = 0; i < col; i++) {
            if (board[col] == board[i]) {
                return false;
            }
            
            if (Math.abs(col - i) == Math.abs(board[col] - board[i])) {
                return false;
            }
        }
        return true;
    }
}
