import java.util.*;

public class Solution {
    public int solution(int n) {
        int battery = 0;
        
        while (n > 0) {
            if (n % 2 == 0) n /= 2;
            else {
                battery++;
                n = (n - 1) / 2;
            }
        }
        
        return battery;
    }
}