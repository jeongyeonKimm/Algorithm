class Solution
{
    public int solution(String s)
    {
        for (int i = s.length(); i > 0; i--) {
            for (int j = 0; j + i <= s.length(); j++) {
                if (isPalindrome(s, i, j, j + i - 1)) {
                    return i;
                }
            }
        }

        return 0;
    }
    
    private boolean isPalindrome(String s, int len, int start, int end) {
        for (int i = 0; i <= len / 2; i++) {
            if (s.charAt(start + i) != s.charAt(end - i)) {
                return false;
            }
        }
        
        return true;
    }
}