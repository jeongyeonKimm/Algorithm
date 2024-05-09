class Solution {
    public int solution(String myString, String pat) {
        String changed = "";
        
        for (char c : myString.toCharArray()) {
            if (c == 'A') changed += String.valueOf('B');
            else changed += String.valueOf('A');
        }
        
        return changed.contains(pat) ? 1 : 0;
    }
}