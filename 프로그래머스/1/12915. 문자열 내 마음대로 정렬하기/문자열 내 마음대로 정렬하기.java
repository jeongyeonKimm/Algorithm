import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<>() {
           @Override
            public int compare(String s1, String s2) {
                if (s1.charAt(n) > s2.charAt(n)) return 1;
                else if (s1.charAt(n) < s2.charAt(n)) return -1;
                else return s1.compareTo(s2);
            }
        });
        
        return strings;
    }
}