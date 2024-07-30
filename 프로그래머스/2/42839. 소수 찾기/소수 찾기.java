import java.util.*;

class Solution {
    
    Set<Integer> madeNums;
    boolean[] visited = new boolean[7];
    
    public int solution(String numbers) {
        madeNums = new HashSet<>();
        
        dfs(numbers, "", 0);
        
        int count = 0;
        
        for (int n : madeNums) {
            if (checkPrime(n)) {
                count++;
            }
        }
        
        return count;
    }
    
    private void dfs(String numbers, String str, int depth) {
        if (depth >= numbers.length()) return;
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                madeNums.add(Integer.parseInt(str + numbers.charAt(i)));
                dfs(numbers, str + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
    }
    
    private boolean checkPrime(int num) {
        if (num < 2) return false;
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}