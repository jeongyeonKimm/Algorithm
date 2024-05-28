class Solution {
    public int solution(String dartResult) {
        int[] result = new int[3];
        char[] dartArr = dartResult.toCharArray();
        int idx = 0;
        
        for (int i = 0; i < dartArr.length; i += 2) {
            int score = dartArr[i] - '0';
            if (Character.isDigit(dartArr[i + 1])) {
                score = score * 10 + (dartArr[i + 1] - '0');
                i++;
            }
            
            if (dartArr[i + 1] == 'S') {
                result[idx] = score;
            } else if (dartArr[i + 1] == 'D') {
                result[idx] = (int)Math.pow(score, 2);
            } else if (dartArr[i + 1] == 'T') {
                result[idx] = (int)Math.pow(score, 3);
            }
            
            if (i + 2 < dartArr.length) {
                if (dartArr[i + 2] == '*') {
                    if (idx >= 1) result[idx - 1] *= 2;
                    result[idx] *= 2;
                    i++;
                } else if (dartArr[i + 2] == '#') {
                    result[idx] *= -1;
                    i++;
                }
            }
            
            idx++;
        }
        
        return  result[0] + result[1] + result[2];
    }
}