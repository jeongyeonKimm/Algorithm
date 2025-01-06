import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        
        Map<String, Integer> counts = new HashMap<>();
        Map<String, List<Music>> musics = new HashMap<>();
        for (int i = 0; i < n; i++) {
            counts.put(genres[i], counts.getOrDefault(genres[i], 0) + plays[i]);
            if (!musics.containsKey(genres[i])) {
                musics.put(genres[i], new ArrayList<>());
            }
            musics.get(genres[i]).add(new Music(i, genres[i], plays[i]));
        }
        
        List<String> keySet = new ArrayList<>(counts.keySet());
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return counts.get(o2).compareTo(counts.get(o1));
            }
        });
        
        for (String key : musics.keySet()) {
            musics.get(key).sort(new Comparator<Music>() {
                @Override
                public int compare(Music o1, Music o2) {
                    if (o1.plays == o2.plays) {
                        return o1.id - o2.id;
                    }
                    return o2.plays - o1.plays;
                }
            });
        }
        
        List<Integer> answer = new ArrayList<>();
        for (String key : keySet) {
            List<Music> albums = musics.get(key);
            int num = Math.min(albums.size(), 2);
            for (int i = 0; i < num; i++) {
                answer.add(albums.get(i).id);
            }
        } 
        
        return answer.stream()
            .mapToInt(i -> i)
            .toArray();
    }
    
    class Music {
        int id;
        String genre;
        int plays;
        
        public Music(int id, String genre, int plays) {
            this.id = id;
            this.genre = genre;
            this.plays = plays;
        }
    }
}