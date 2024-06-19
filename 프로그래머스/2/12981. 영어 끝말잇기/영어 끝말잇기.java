import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(int n, String[] words) {
        Map<String, Integer> saidWords = new HashMap<>();
        
        int number = 0;
        int turn = 0; 
        
        String curWord = words[0];
        saidWords.put(curWord, 1);
        
        for (int i = 1; i < words.length; i++) {
            curWord = words[i];
            String prevWord = words[i - 1];
            char curFirstAlpha = curWord.charAt(0);
            char prevLastAlpha = prevWord.charAt(prevWord.length() - 1);
            
            if ((saidWords.getOrDefault(curWord, 0) == 1) || (i > 0 && prevLastAlpha != curFirstAlpha)) {
                number = (i % n) + 1;
                turn = (i / n) + 1;
                break;
            }
            saidWords.put(curWord, 1);
        }
        return new int[] {number, turn};
    }
}