class Solution {
    public int[] solution(int n, int m) {
        int gcd = 0;
        int lcm = 0;
        for (int i = Math.min(n, m); i >= 1; i--) {
            if (n % i == 0 && m % i == 0) {
                gcd = i;
                lcm = n * m / gcd;
                break;
            }
        }
        
        return new int[] {gcd, lcm};
    }
}