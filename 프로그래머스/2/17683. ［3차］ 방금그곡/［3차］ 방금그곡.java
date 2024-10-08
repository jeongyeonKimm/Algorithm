class Solution {
    public String solution(String m, String[] musicinfos) {
        m = changeMelody(m);

        String answer = "";
        int maxPlayTime = Integer.MIN_VALUE;

        for (String info : musicinfos) {
            String[] musicInfo = info.split("[:,]");
            int start = Integer.parseInt(musicInfo[0]) * 60 + Integer.parseInt(musicInfo[1]);
            int end = Integer.parseInt(musicInfo[2]) * 60 + Integer.parseInt(musicInfo[3]);
            int playTime = end - start;
            String title = musicInfo[4];
            String melody = musicInfo[5];
            
            melody = changeMelody(melody);

            String played = "";

            if (playTime <= melody.length()) {
                played = melody.substring(0, playTime);
            } else {
                StringBuilder sb = new StringBuilder();
                
                for (int i = 0; i < playTime / melody.length(); i++) {
                    sb.append(melody);
                }
                sb.append(melody.substring(0, playTime % melody.length()));
                played = sb.toString();
            }

            if (played.contains(m) && playTime > maxPlayTime) {
                answer = title;
                maxPlayTime = playTime;
            }
        }

        if (maxPlayTime == Integer.MIN_VALUE) {
            return "(None)";
        } else {
            return answer;
        }
    }

    String changeMelody(String melody) {
        melody = melody.replaceAll("C#", "H");
        melody = melody.replaceAll("D#", "I");
        melody = melody.replaceAll("F#", "J");
        melody = melody.replaceAll("G#", "K");
        melody = melody.replaceAll("A#", "L");
        melody = melody.replaceAll("B#", "M");

        return melody;
    }
}