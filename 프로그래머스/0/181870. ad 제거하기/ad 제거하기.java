import java.util.Arrays;

class Solution {
    public String[] solution(String[] strArr) {
        return Arrays.stream(strArr)
            .filter(s -> !s.contains("ad"))
            .toArray(String[]::new);
    }
}