import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        
        String[] splitted = s.replace("},{", " ").split(" ");
        Arrays.sort(splitted, new Comparator<String>(){
            public int compare(String o1, String o2){
                return Integer.compare(o1.length(), o2.length());
            }
        });
        
        List<Integer> result = new ArrayList<>();
        for (String str : splitted) {
            String[] numbers = str.split(",");
            for (String n : numbers) {
                if (!result.contains(Integer.parseInt(n))) {
                    result.add(Integer.parseInt(n));
                }
            }
        }
        
        return result.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}