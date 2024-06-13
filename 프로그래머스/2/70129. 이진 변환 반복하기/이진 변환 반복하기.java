import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String s) {
        int count = 0;
        int removedZero = 0;
        String tmp;
        while (true) {
            tmp = s.replaceAll("0", "");
            removedZero += (s.length() - tmp.length());
            count++;
            s = Integer.toBinaryString(tmp.length());
            if (s.equals("1")) break;
        }
        
        return new int[] {count, removedZero};
    }
}