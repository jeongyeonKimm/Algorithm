class Solution {
    
    private int[] board;
    private int result = 0;
    
    public int solution(int n) {
        board = new int[n]; // (i, board[i])에 queen 위치
        
        backtracking(0, n);
        
        return result;
    }
    
    private void backtracking(int row, int n) {
        if (row == n) {
            result++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            board[row] = i;
            
            if (isPossible(row, n)) {
                backtracking(row + 1, n);
            }
        }
    }
    
    private boolean isPossible(int row, int n) {
        for (int i = 0; i < row; i++) {
            if (board[row] == board[i]) {   // 같은 세로줄에 위치
                return false;
            }
            
            if (Math.abs(row - i) == Math.abs(board[row] - board[i])) { // 대각선에 위치(대각선은 가로와 세로 각각의 절대값이 같음)
                return false;
            }
        }
        return true;
    }
}
