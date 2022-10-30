package implementation;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2346, 풍선 터뜨리기 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_2346 {
    static int N;
    static Deque<int[]> deque = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            deque.addLast(new int[] { i, Integer.parseInt(st.nextToken()) });
        }
        br.close();
        
        StringBuilder sb = new StringBuilder();
        while (deque.size() > 0) {
            int[] curr = deque.removeFirst();
            sb.append(curr[0]).append(" ");
            if (deque.size() == 0) break;
            
            if (curr[1] > 0) curr[1]--;
            
            while (curr[1] != 0) {
                if (curr[1] < 0) {
                    deque.addFirst(deque.removeLast());
                    curr[1]++;
                } else {
                    deque.addLast(deque.removeFirst());
                    curr[1]--;
                }
            }
        }
        System.out.println(sb.toString().trim());
    }

}
