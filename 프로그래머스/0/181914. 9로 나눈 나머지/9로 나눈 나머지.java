class Solution {
    public int solution(String number) {
        int answer = 0;
        for (char c : number.toCharArray()) {
            answer += (int) (c - '0');
        }
        
        return answer % 9;
    }
}