class Solution {
    public int solution(String[] board) {
        int OCount = 0;
        int XCount = 0;
        
        for (int i = 0; i < 3; i++) {
            OCount += countChar(board[i], "O");
            XCount += countChar(board[i], "X");
        }
        
        if (OCount < XCount) {
            return 0;
        }
        
        if (OCount >= XCount + 2) {
            return 0;
        }
        
        if (checkWin(board, 'O')) {
            if (OCount == XCount) {
                return 0;
            }
        }
        
        if (checkWin(board, 'X')) {
            if (OCount == XCount + 1) {
                return 0;
            }
        }
        
        return 1;
    }
    
    private int countChar(String b, String c) {
        return 3 - b.replace(c, "").length();
    }
    
    private boolean checkWin(String[] board, char c) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == c && 
                board[i].charAt(1) == c && 
                board[i].charAt(2) == c) {
                return true;
            }
        }
        
        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == c && 
                board[1].charAt(i) == c && 
                board[2].charAt(i) == c) {
                return true;
            }
        }
        
        if (board[0].charAt(0) == c && 
            board[1].charAt(1) == c && 
            board[2].charAt(2) == c) {
            return true;
        }
        
        if (board[0].charAt(2) == c && 
            board[1].charAt(1) == c && 
            board[2].charAt(0) == c) {
            return true;
        }
        
        return false;
    }
}