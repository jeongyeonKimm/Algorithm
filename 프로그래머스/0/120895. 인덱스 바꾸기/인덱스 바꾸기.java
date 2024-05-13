class Solution {
    public String solution(String my_string, int num1, int num2) {
        char s1 = my_string.charAt(num1);
        char s2 = my_string.charAt(num2);
        
        return my_string.substring(0, num1) + s2 + my_string.substring(num1 + 1, num2)
            + s1 + my_string.substring(num2 + 1);
    }
}