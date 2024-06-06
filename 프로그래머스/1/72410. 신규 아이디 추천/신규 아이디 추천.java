class Solution {
    public String solution(String new_id) {
        String result = new_id.toLowerCase();
        result = result.replaceAll("[^a-z0-9-_.]", "");
        result = result.replaceAll("[.]{2,}", ".");
        result = result.replaceAll("^[.]|[.]$", "");
        result = result.isEmpty() ? "a" : result;
        result = result.length() >= 16 ? result.substring(0, 15) : result;
        result = result.replaceAll("[.]$", "");
        int len =  result.length();
        if (len <= 2) {
            char ch = result.charAt(len - 1);
            for (int i = 0; i < 3 - len; i++) {
                result += ch;
            }
        }
        return result;
    }
}