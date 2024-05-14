class Solution {
    public int solution(int num, int k) {
        String numToStr = String.valueOf(num);
        
        int answer = numToStr.indexOf(String.valueOf(k));
        
        if (answer != -1) {
            return answer + 1;
        }
        return answer;
    }
}