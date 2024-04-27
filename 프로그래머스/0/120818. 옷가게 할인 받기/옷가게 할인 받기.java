class Solution {
    public int solution(int price) {
        double sale;
        
        if (price >= 500000) sale = 0.8;
        else if (price >= 300000) sale = 0.9;
        else if (price >= 100000) sale = 0.95;
        else sale = 1.0;
        
        return (int)(price * sale);
    }
}