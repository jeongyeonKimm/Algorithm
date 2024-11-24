class Solution
{
    public int solution(int [][]board)
    {
        int rows = board.length;
        int cols = board[0].length;
        
        if (rows < 2 || cols < 2) {
            return board[0][0] == 1 ? 1 : 0;
        }
        
        int maxLength = 0;
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (board[i][j] != 0) {
                    board[i][j] = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;
                }
                
                maxLength = Math.max(maxLength, board[i][j]);
            }
        }
        
        return maxLength * maxLength;
    }
}