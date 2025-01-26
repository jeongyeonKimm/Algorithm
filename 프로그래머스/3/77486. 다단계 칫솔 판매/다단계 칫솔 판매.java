import java.util.*;

class Solution {
    
    private Map<String, String> parents;
    private Map<String, Integer> totalAmount;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        int m = seller.length;
        
        parents = new HashMap<>();
        totalAmount = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            parents.put(enroll[i], referral[i]);
        }
        
        for (int i = 0; i < m; i++) {
            distributeProfits(seller[i], amount[i] * 100);
        }
        
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = totalAmount.getOrDefault(enroll[i], 0);
        }
        
        return answer;
    }
    
    private void distributeProfits(String seller, int amount) {
        int distribution = amount / 10;
        totalAmount.put(seller, totalAmount.getOrDefault(seller, 0) + amount - distribution);
        
        if (distribution >= 1 && parents.containsKey(seller)) {
            distributeProfits(parents.get(seller), distribution);
        }
    }
}