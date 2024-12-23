class Solution {
    
    private int[] score;
    private int[] answer;
    private int maxDiff = -1;
    
    public int[] solution(int n, int[] info) {
        score = new int[info.length];
        answer = new int[info.length];
        
        backtracking(n, info, 0);
        
        if (maxDiff == -1) {
            return new int[] {-1};
        }
        
        return answer;
    }
    
    private void backtracking(int n, int[] info, int depth) {
        if (depth == n) {
            int diff = calculateScore(info);
            if (maxDiff <= diff) {
                maxDiff = diff;
                answer = score.clone();
            }
            return;
        }
        
        for (int i = 0; i < info.length && info[i] >= score[i]; i++) {
            score[i] += 1;
            backtracking(n, info, depth + 1);
            score[i] -= 1;
        }
    }
    
    private int calculateScore(int[] info) {
        int player1 = 0;
        int player2 = 0;
        
        for (int i = 0; i < info.length; i++) {
            if (info[i] == 0 && score[i] == 0) {
                continue;
            } else if (info[i] >= score[i]) {
                player1 += (10 - i);
            } else {
                player2 += (10 - i);
            }
        }
        
        int diff = player2 - player1;
        
        return diff <= 0 ? -1 : diff;
    }
}