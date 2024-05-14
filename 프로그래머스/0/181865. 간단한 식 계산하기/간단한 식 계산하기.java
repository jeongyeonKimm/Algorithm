class Solution {
    public int solution(String binomial) {
        String[] arr = binomial.split(" ");
        
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[2]);
        String op = arr[1];
        
        if (op.equals("+")) {
            return a + b;
        } else if (op.equals("-")) {
            return a - b;
        } else {
            return a * b;
        }
    }
}