class Solution {
    public int solution(int[] arr) {
        // A * B = gcd * lcm
        // lcm = (A / gcd) * (B / gcd) * gcd
        int lcm = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int g = gcd(lcm, arr[i]);
            lcm = (lcm / g) * (arr[i] / g) * g;
        } 
        
        return lcm;
    }
    
    private int gcd(int a, int b) {
        if (a > b) 
            return (a % b == 0) ? b : gcd(b, a % b); 
        else 
            return (b % a == 0) ? a : gcd(a, b % a);
    }
}
