import java.util.Arrays;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        int idx = 0;
        
        for (int i = 0; i < number.length() - k; i++) {
            char maxChar = '0';
            for (int j = idx; j <= i + k; j++) {
                if (maxChar < number.charAt(j)) {
                    maxChar = number.charAt(j);
                    idx = j + 1;
                }
            }
            sb.append(maxChar);
        }
        
        return sb.toString();
    }
}