class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        
        int maxHealth = health;
        int curHealth = health;
        int contAttack = 0;
        int prevAttack = 0;
        
        for (int[] attack : attacks) {
            if (curHealth <= 0) return -1;
            
            contAttack = attack[0] - prevAttack - 1;
            
            curHealth = Math.min(maxHealth, curHealth + (x * contAttack));
            curHealth = Math.min(maxHealth, curHealth + (y * (contAttack / t)));          
            curHealth -= attack[1];
            
            prevAttack = attack[0];
        }
        
        return curHealth <= 0 ? -1 : curHealth;
    }
}