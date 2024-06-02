class Solution {
    public int solution(int[] ingredient) {
        int count = 0;
        
        int top = 0;
        int[] stack = new int[ingredient.length];
        for (int i : ingredient) {
            stack[top++] = i;
            if (top >= 4 && 
                stack[top - 1] == 1 && stack[top - 2] == 3 &&
                stack[top - 3] == 2 && stack[top - 4] == 1) {
                count++;
                top -= 4;
            }
        }
        return count;
    }
}