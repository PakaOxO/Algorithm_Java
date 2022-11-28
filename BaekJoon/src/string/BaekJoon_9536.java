package string;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_9536, 여우는 어떻게 울지? 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 해시맵을 사용한 문자열 필터링 
 *
 */
public class BaekJoon_9536 {
    static Map<String, String> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int tc=0; tc<T; tc++) {
            map = new HashMap<>();
            String[] input = br.readLine().split(" ");
            Queue<String> q = new LinkedList<>();
            for (int i=0; i<input.length; i++) {
                q.offer(input[i]);
            }
            
            String next = null;
            while (true) {
                next = br.readLine();
                if (next.equals("what does the fox say?")) break;
                String[] goes = next.split(" ");
                
                if (map.containsKey(goes[0])) continue;
                map.put(goes[0], goes[2]);
                
                int q_size = q.size();
                for (int i=0; i<q_size; i++) {
                    String curr = q.poll();
                    if (curr.equals(goes[2])) {
                        continue;
                    }
                    q.offer(curr);
                }
            }
            
            while (!q.isEmpty()) {
                sb.append(q.poll()).append(" ");
            }
            sb.append("\n");
        }
        br.close();
        System.out.println(sb.toString().trim());
    }

}
