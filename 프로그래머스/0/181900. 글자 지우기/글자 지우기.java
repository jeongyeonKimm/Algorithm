class Solution {
    public String solution(String my_string, int[] indices) {
        char[] c = my_string.toCharArray();
        for (int idx : indices) {
            c[idx] = '-';
        }
        
        return new String(c).replaceAll("-", "");
    }
}