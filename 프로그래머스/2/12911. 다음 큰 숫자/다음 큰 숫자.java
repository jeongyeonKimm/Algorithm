class Solution {
    public int solution(int n) {
        int answer = 0;
        int nextNum = n + 1;
        while (true) {
            int zeroN = Integer.bitCount(n);
            int zeroNext = Integer.bitCount(nextNum);
            if (zeroN == zeroNext) {
                answer = nextNum;
                break;
            }
            nextNum++;
        }
        return answer;
    }
}