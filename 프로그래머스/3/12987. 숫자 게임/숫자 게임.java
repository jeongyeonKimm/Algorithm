import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int score = 0;
        
        for (int i = A.length - 1, j = B.length - 1; i >= 0; i--) {
            if (A[i] < B[j]) {
                score++;
                j--;
            }
        }
        
        return score;
    }
}