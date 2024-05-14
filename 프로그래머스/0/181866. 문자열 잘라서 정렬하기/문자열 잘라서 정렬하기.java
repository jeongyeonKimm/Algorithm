import java.util.Arrays;

class Solution {
    public String[] solution(String myString) {
        String[] answer = myString.split("x");
        
        return Arrays.stream(answer)
            .filter(s -> s.length() > 0)
            .sorted()
            .toArray(String[]::new);
    }
}