import java.util.Arrays;

class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        
        Arrays.sort(arr);
        
        String newStr = new String(arr);        
        StringBuilder sb = new StringBuilder(newStr);
        sb.reverse();
        
        return sb.toString();
    }
}