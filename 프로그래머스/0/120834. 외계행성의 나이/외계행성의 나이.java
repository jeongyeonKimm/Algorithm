class Solution {
    public String solution(int age) {
        String answer = "";
        
        while (age > 0) {
            answer += String.valueOf((char) ('a' + (age % 10)));
            age /= 10;
        }
        
        return new StringBuffer(answer).reverse().toString();
    }
}