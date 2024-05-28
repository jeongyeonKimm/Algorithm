class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for (String b : babbling) {
            if (b.contains("ayaaya") || b.contains("yeye") || b.contains("woowoo") || b.contains("mama")) {
                continue;
            }
            
            b = b.replace("aya", " ");
            b = b.replace("ye", " ");
            b = b.replace("woo", " ");
            b = b.replace("ma", " ");
            b = b.replace(" ", "");
            
            if (b.length() == 0) answer++;
        }
        return answer;
    }
}