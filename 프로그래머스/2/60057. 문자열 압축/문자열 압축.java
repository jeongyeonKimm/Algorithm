class Solution {
    public int solution(String s) {
        int minLength = s.length();
        
        for (int i = 1; i <= s.length() / 2; i++) {
            String splitted = getSplittedString(s, i, 1).toString();
            minLength = Math.min(minLength, splitted.length());
        }
        
        return minLength;
    }
    
    public StringBuilder getSplittedString(String str, int splittedLen, int count) {
        if (str.length() < splittedLen) return new StringBuilder(str);
        
        String pre = str.substring(0, splittedLen);
        String post = str.substring(splittedLen, str.length());
        StringBuilder result = new StringBuilder();
        
        if (!post.startsWith(pre)) {
            if (count > 1) result.append(count);
            result.append(pre);
            return result.append(getSplittedString(post, splittedLen, 1));
        }
        
        return result.append(getSplittedString(post, splittedLen, count + 1));
    }
}