import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> pokemons = new HashSet<>();
        for (int num : nums) {
            pokemons.add(num);
        }
        
        if (pokemons.size() >= nums.length / 2) {
            return nums.length / 2;
        }
        return pokemons.size();
    }
}