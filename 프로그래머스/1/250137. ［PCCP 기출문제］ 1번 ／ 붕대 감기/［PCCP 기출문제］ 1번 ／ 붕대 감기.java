class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        
        int lastAttack = attacks[attacks.length - 1][0];
        int maxHealth = health;
        int continuousAttack = 0;
        int j = 0;
        
        for (int i = 1; i <= lastAttack; i++) {
            if (attacks[j][0] == i) {
                continuousAttack = 0;
                health -= attacks[j][1];
                if (health <= 0) {
                    return -1;
                }
                j++;
            } else {
                continuousAttack++;
            
                if (health < maxHealth) {
                    health += x;
                }
                if (continuousAttack == t) {
                    health += y;
                    continuousAttack = 0;
                }
                
                if (health > maxHealth) health = maxHealth;
            }
        }
        
        return health;
    }
}