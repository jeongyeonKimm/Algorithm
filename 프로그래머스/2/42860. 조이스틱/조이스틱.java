class Solution {
    public int solution(String name) {
        int len = name.length();
        int consecutiveA = 0;
        int horizontalMoveCount = name.length() - 1;
        int answer = 0;
        
        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
            
            consecutiveA = i + 1;
            
            while (consecutiveA < len && name.charAt(consecutiveA) == 'A') {
                consecutiveA++;
            }
            
            horizontalMoveCount = Math.min(horizontalMoveCount, i * 2 + len - consecutiveA);
            horizontalMoveCount = Math.min(horizontalMoveCount, (name.length() - consecutiveA) * 2 + i);
        }
        
        return answer + horizontalMoveCount;
    }
}