import java.math.BigInteger;

class Solution {
    public long solution(int w, int h) {
        BigInteger W = BigInteger.valueOf(w);
        BigInteger H = BigInteger.valueOf(h);
        long gcd = W.gcd(H).longValue();
        
        long clipped = gcd * (((long) w / gcd) + ((long) h / gcd) - 1);
        
        return ((long) w * (long) h) - clipped;
    }
}