class Solution {
    public int solution(int[] stones, int k) {
        int min = 200000000;
        int max = 0;
        
        for (int stone : stones) {
            min = Math.min(min, stone);
            max = Math.max(max, stone);
        }
        
        while (min < max) {
            int mid = (min + max + 1) / 2;
            
            if (isPossible(stones, k, mid)) {
                min = mid;
            } else {
                max = mid - 1;
            }
        }
        
        return max;
    }
    
    private boolean isPossible(int[] stones, int k, int friends) {
        int count = 0;
        
        for (int stone : stones) {
            if (stone - friends < 0) {
                count++;
            } else {
                count = 0;
            }
            
            if (count == k) {
                return false;
            }
        }
        
        return true;
    }
}