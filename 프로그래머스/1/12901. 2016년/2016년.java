class Solution {
    public String solution(int a, int b) {
        int[] date = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        
        int sum = 0;
        for (int i = 1; i < a; i++) {
            sum += date[i - 1];
        }
        sum += (b - 1);
        
        return day[sum % 7];
    }
}