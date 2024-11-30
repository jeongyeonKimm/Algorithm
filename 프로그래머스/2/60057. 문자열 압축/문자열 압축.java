class Solution {
    public int solution(String s) {
        int minLength = s.length();
        
        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            String prev = s.substring(0, i);
            for (int j = i; j < s.length(); j += i) {
                int endIdx = Math.min(j + i, s.length());
                String tmp = s.substring(j, endIdx);
                if (tmp.equals(prev)) {
                    count++;
                } else {
                    if (count > 1) {
                        sb.append(count);
                    }
                    sb.append(prev);
                    count = 1;
                    prev = tmp;
                }
            }
            
            if (count > 1) {
                sb.append(count);
            }
            sb.append(prev);

            minLength = Math.min(minLength, sb.length());
        }
        
        return minLength;
    }
}