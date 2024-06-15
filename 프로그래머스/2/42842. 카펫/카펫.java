class Solution {
    public int[] solution(int brown, int yellow) {
        int width = 0;
        int height = 0;
        for (int i = 1; i <= yellow; i++) {
            for (int j = 1; j <= yellow; j++) {
                if ((i * j == yellow) && (2 * i + 2 * j + 4 == brown)) {
                    width = j + 2;
                    height = i + 2;
                    return new int[] {width, height};
                }
            }
        }
        
        return new int[] {width, height};
    }
}