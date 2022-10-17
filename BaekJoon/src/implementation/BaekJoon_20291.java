package implementation;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_20291, 파일 정리
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. TreeMap을 사용해야 했던 문제
 *  2. 처음 List에 넣고 Collections.sort를 사용했을 때는 시간 초과, 우선순위 큐로 바꿔서 해결
 *
 */
public class BaekJoon_20291 {
    static class File implements Comparable<File> {
        String type;
        int cnt;
        
        File(String type, int cnt) {
            this.type = type;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(File o) {
            return this.type.compareTo(o.type);
        }
    }
    
    static Map<String, Integer> files;
    static PriorityQueue<File> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        files = new HashMap<>();
        for (int i=0; i<N; i++) {
            String[] file = br.readLine().split("\\.");
            if (!files.containsKey(file[1])) {
                files.put(file[1], 1);
            } else {
                files.put(file[1], files.get(file[1]) + 1);
            }
        }
        br.close();

        pq = new PriorityQueue<>();
        for (String key : files.keySet()) {
            pq.offer(new File(key, files.get(key)));
        }
        
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            File f = pq.poll();
            sb.append(String.format("%s %d\n", f.type, f.cnt));
        }
        System.out.print(sb);
    }

}
