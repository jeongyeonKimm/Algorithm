import java.util.ArrayList;

class Solution {
    
    ArrayList<int[]> answer;
    
    public int[][] solution(int n) {
        answer = new ArrayList<>();
        
        hanoi(n, 1, 2, 3);
        
        return answer.stream()
            .toArray(int[][]::new);
    }
    
    private void hanoi(int n, int from, int aux, int to) {
        if (n == 1) {
            answer.add(new int[] {from, to});
            return;
        }
        
        hanoi(n - 1, from, to, aux);
        answer.add(new int[] {from, to});
        hanoi(n - 1, aux, from, to);
        return;
    }
}