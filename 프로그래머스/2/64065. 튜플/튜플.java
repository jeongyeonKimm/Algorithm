import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        
        String[] splitted = s.replace("},{", " ").split(" ");
        Arrays.sort(splitted, (o1, o2) -> o1.length() - o2.length());
        
        List<Integer> result = new ArrayList<>();
        for (String str : splitted) {
            for (String n : str.split(",")) {
                int number = Integer.parseInt(n);
                if (!result.contains(number)) {
                    result.add(number);
                }
            }
        }
        
        return result.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}