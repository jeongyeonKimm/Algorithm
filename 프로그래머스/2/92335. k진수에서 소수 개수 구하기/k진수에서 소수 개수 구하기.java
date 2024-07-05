import java.util.Arrays;

class Solution {
    public int solution(int n, int k) {
        String primeNumber = Integer.toString(n, k);
        
        String[] splitted = primeNumber.split("0");
        
        int count = 0;
        for (int i = 0; i < splitted.length; i++) {
            if (splitted[i].equals("")) continue;
            if (isPrime(Long.parseLong(splitted[i]))) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isPrime(long num) {
        if (num <= 1) return false;
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}