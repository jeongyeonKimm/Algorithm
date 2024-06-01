class Solution {
    public String solution(String X, String Y) {
        int[] xCount = new int[10];
        int[] yCount = new int[10];
        
        for (char x : X.toCharArray()) {
            xCount[x - '0']++;
        }
        
        for (char y : Y.toCharArray()) {
            yCount[y - '0']++;
        }
        
        StringBuilder maxNum = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < Math.min(xCount[i], yCount[i]); j++) {
                maxNum.append(i);
            }
        }
        
        String result = maxNum.toString();
        if (result.length() == 0) return "-1";
        else if (result.charAt(0) == '0') return "0";
        else return result;
    }
}