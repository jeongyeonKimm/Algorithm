import java.util.ArrayList;

class Solution {
    
    public int[] solution(int n, long k) {
        ArrayList<Integer> numbers = new ArrayList<>();
        int[] result = new int[n];
        
        long factorial = 1;
        
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            factorial *= i;
        }
        
        k--;
        
        int idx = 0;
        
        while (idx < n) {
            factorial = factorial / (n - idx);
            result[idx++] = numbers.remove((int) (k / factorial));
            k = k % factorial;
        }
        
        return result;
    }
}