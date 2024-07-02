import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        List<String> multiSet1 = new ArrayList<>();
        List<String> multiSet2 = new ArrayList<>();
        
        for (int i = 0; i < str1.length() - 1; i++) {
            String subStr = str1.substring(i, i + 2);
            if (isAllAlphabet(subStr)) {
                multiSet1.add(subStr);
            }
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
            String subStr = str2.substring(i, i + 2);
            if (isAllAlphabet(subStr)) {
                multiSet2.add(subStr);
            }
        }
        
        Collections.sort(multiSet1);
        Collections.sort(multiSet2);
        
        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();
        
        for (String s : multiSet1) {
            if (multiSet2.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }
        
        for (String s : multiSet2) {
            union.add(s);
        }
        
        double jaccard = 1;
        if (union.size() != 0) jaccard = (double) intersection.size() / (double) union.size();
        
        return (int) (jaccard * 65536);
    }
    
    private boolean isAllAlphabet(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
}