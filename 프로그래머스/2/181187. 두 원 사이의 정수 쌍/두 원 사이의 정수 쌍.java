class Solution {
    public long solution(int r1, int r2) {
        return countIntegerPair(r2) - countIntegerPair(r1) + countRadius(r1);
    }
    
    private long countIntegerPair(int radius) {
        long count = 0;
        
        for (int i = 0; i <= radius; i++) {
            count += (int) Math.sqrt(Math.pow(radius, 2) - Math.pow(i, 2));
        }
        
        return 4 * count + 1;
    }
    
    private long countRadius(int radius) {
        long count = 0;
        
        for (int i = 1; i < radius; i++) {
            int len = (int) Math.sqrt(Math.pow(radius, 2) - Math.pow(i, 2));
            if (Math.pow(radius, 2) == Math.pow(i, 2) + Math.pow(len, 2)) {
                count++;
            }
        }
        
        return count * 4 + 4;
    }
}