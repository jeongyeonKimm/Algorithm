class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        int result = 0;
        
        if (notDivisible(gcdA, arrayB)) {
            result = Math.max(result, gcdA);   
        }
        
        if (notDivisible(gcdB, arrayA)) {
            result = Math.max(result, gcdB);   
        }
        
        return result;
    }
    
    public boolean notDivisible(int gcd, int[] array) {
        for (int i : array) {
            if (i % gcd == 0) {
                return false;
            }
        }
        return true;
    }
    
    public int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}