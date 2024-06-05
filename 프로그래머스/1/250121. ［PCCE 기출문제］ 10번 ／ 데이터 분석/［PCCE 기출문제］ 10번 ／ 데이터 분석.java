import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int idx = getIndex(ext);
        int sortIdx = getIndex(sort_by);
        
        List<int[]> selected = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (data[i][idx] < val_ext) {
                selected.add(data[i]);
            }
        }
        
        Collections.sort(selected, (o1, o2) -> o1[sortIdx] - o2[sortIdx]);
        
        return selected.toArray(new int[selected.size()][]);
    }
    
    private int getIndex(String val) {
        if (val.equals("code")) return 0;
        else if (val.equals("date")) return 1;
        else if (val.equals("maximum")) return 2;
        else return 3;
    }
}