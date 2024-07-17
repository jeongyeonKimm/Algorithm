import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        File[] fileArr = new File[files.length];
        for (int i = 0; i < files.length; i++) {
            fileArr[i] = new File(files[i]);
        }
        
        Arrays.sort(fileArr, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if ((o1.head).equals(o2.head)) {
                    return o1.number - o2.number;
                }
                return (o1.head).compareTo(o2.head);
            }
        });
        
        String[] result = new String[fileArr.length];
        for (int i = 0; i < fileArr.length; i++) {
            result[i] = fileArr[i].fileName;
        }
        
        return result;
    }
}

class File {
    
    String fileName;
    String head;
    int number;
    
    public File(String file) {
        this.fileName = file;
        this.head = file.split("[0-9]")[0].toUpperCase();
        String numberStr = file.substring(this.head.length(), Math.min(this.head.length() + 5, file.length()));
        this.number = Integer.parseInt(numberStr.split("[^0-9]")[0]);
    }
}