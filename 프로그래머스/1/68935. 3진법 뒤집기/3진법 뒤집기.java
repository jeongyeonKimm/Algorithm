class Solution {
    public int solution(int n) {
        String num = Integer.toString(n, 3);
        
        StringBuilder sb = new StringBuilder(num);
        sb.reverse();
        
        return Integer.parseInt(sb.toString(), 3);
    }
}