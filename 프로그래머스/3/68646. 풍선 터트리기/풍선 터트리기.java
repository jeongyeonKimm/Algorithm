import java.util.*;

class Solution {
    public int solution(int[] a) {
        int n = a.length;
        int leftMin = Integer.MAX_VALUE;
        int rightMin = Integer.MAX_VALUE;
        
        Set<Integer> hs = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            leftMin = Math.min(leftMin, a[i]);
            rightMin = Math.min(rightMin, a[n - 1 - i]);
            
            hs.add(leftMin);
            hs.add(rightMin);
        }
        
        return hs.size();
    }
}