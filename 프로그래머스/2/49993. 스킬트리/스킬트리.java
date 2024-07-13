class Solution {
    public int solution(String skill, String[] skill_trees) {
        int count = 0;
        
        for (String str : skill_trees) {
            int idx = 0;
            boolean flag = true;
            for (char c : str.toCharArray()) {
                int cur = skill.indexOf(c);
                if (cur == -1) {
                    continue;
                }
                
                if (cur == idx) {
                    idx++;
                } else {
                    flag = false;
                    break;
                }
            }
            
            if (flag) count++;
        }
        
        return count;
    }
}