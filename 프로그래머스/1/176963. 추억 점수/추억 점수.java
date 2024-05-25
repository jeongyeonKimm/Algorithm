import java.util.List;
import java.util.Arrays;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<String> nameList = Arrays.asList(name);
        
        int[] answer = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (String n : photo[i]) {
                if (nameList.contains(n)) {
                    sum += yearning[nameList.indexOf(n)];
                }
            }
            answer[i] = sum;
        }
        return answer;
    }
}