class Solution {
    public long solution(long n) {
        if (n % Math.sqrt(n) == 0) {
            return (long)Math.pow(Math.sqrt(n) + 1, 2);
        } else {
            return -1;
        }
    }
}