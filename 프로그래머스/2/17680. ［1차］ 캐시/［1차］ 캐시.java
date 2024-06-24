import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;
        
        List<String> cache = new ArrayList<>();
        int time = 0;
        
        for (String city : cities) {
            city = city.toUpperCase();

            if (cache.contains(city)) {
                time += 1;
                cache.remove(city);
                cache.add(city);
                continue;
            }   
            
            if (cache.size() == cacheSize) {
                cache.remove(0);
            }
            cache.add(city);
            time += 5;
        }
        
        return time;
    }
}