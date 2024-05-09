class Solution {
    public int solution(String myString, String pat) {
        String changed = myString.replaceAll("A", "a")
                                .replaceAll("B", "A")
                                .replaceAll("a", "B");
        
        return changed.contains(pat) ? 1 : 0;
    }
}