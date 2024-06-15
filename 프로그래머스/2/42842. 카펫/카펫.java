class Solution {
    public int[] solution(int brown, int yellow) {
        int width = 0;
        int height = 0;
        for (int i = 1; i <= yellow; i++) {
            if ((yellow % i == 0) && (2 * i + 2 * (yellow / i) + 4 == brown)) {
                height = i + 2;
                width = (yellow / i) + 2;
                break;
            }
        }
        
        return new int[] {width, height};
    }
}