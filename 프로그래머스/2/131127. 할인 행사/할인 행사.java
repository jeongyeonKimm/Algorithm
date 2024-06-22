import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        int count = 0;
        for (int i = 0; i < discount.length - 10 + 1; i++) {
            Map<String, Integer> discountInfo = new HashMap<>();
            for (int j = i; j < i + 10; j++) {
                discountInfo.put(discount[j], discountInfo.getOrDefault(discount[j], 0) + 1);
            }
            
            boolean signup = true;
            for (int j = 0; j < want.length; j++) {
                if (wantMap.get(want[j]) != discountInfo.get(want[j])) {
                    signup = false;
                    break;
                }
            }
            
            count += signup ? 1 : 0;
        }
        
        return count;
    }
}