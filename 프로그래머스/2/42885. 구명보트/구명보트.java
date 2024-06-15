import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int boat = 0;
        int idx = 0;
        for (int i = people.length - 1; i >= idx; i--) {
            if (people[i] + people[idx] <= limit) {
                boat++;
                idx++;
            } else {
                boat++;
            }  
        }
        
        return boat;
    }
}