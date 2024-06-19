import java.util.Set;
import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> saidWords = new HashSet<>();
        
        int number = 0;
        int turn = 0; 
        
        String curWord = words[0];
        saidWords.add(curWord);
        
        for (int i = 1; i < words.length; i++) {
            curWord = words[i];
            String prevWord = words[i - 1];
            char curFirstAlpha = curWord.charAt(0);
            char prevLastAlpha = prevWord.charAt(prevWord.length() - 1);
            
            saidWords.add(curWord);
            
            if ((saidWords.size() != i + 1) || (i > 0 && prevLastAlpha != curFirstAlpha)) {
                number = (i % n) + 1;
                turn = (i / n) + 1;
                break;
            }
        }
        return new int[] {number, turn};
    }
}