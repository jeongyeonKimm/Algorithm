import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        ArrayList<String> skillTrees = new ArrayList<>(Arrays.asList(skill_trees));
        Iterator<String> it = skillTrees.iterator();
        
        while (it.hasNext()) {
            if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
                it.remove();
            }
        }
        
        return skillTrees.size();
    }
}