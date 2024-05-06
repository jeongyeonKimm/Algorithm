class Solution {
    public int solution(int a, int b) {
        String strNum = String.valueOf(a) + String.valueOf(b);
        int num = Integer.parseInt(strNum);
        
        return num >= 2 * a * b ? num : 2 * a * b;
    }
}