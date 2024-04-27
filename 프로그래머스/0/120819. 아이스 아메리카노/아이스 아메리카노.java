class Solution {
    public int[] solution(int money) {
        int americano = money / 5500;
        int balance = money % 5500;
        
        return new int[] {americano, balance};
    }
}