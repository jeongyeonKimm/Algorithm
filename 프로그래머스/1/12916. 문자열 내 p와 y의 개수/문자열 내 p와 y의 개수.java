class Solution {
    boolean solution(String s) {
        s = s.toUpperCase();
        
        long countP = s.chars().filter(c -> c == 'P').count();
        long countY = s.chars().filter(c -> c == 'Y').count();
        
        return countP == countY;
    }
}