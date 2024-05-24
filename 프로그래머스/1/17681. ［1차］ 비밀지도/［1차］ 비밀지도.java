class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] map = new String[n];
        for (int i = 0; i < n; i++) {
            map[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }
        
        String form = "%" + n + "s";
        for (int i = 0; i < n; i++) {
            map[i] = String.format(form, map[i]);
            map[i] = map[i].replaceAll("1", "#");
            map[i] = map[i].replaceAll("0", " ");
        }
        
        return map;
    }
}