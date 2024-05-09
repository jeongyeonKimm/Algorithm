import java.util.Arrays;

class Solution {
    public int[] solution(String myString) {
        String[] strArr = myString.split("x", -1);
        
        return Arrays.stream(strArr)
            .mapToInt(s -> s.length())
            .toArray();
    }
}