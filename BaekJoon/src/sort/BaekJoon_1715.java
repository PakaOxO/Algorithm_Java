package sort;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1715, 카드 정렬하기 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_1715 {
    static int N;
    static long min, answer;
    static int[] cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i=0; i<N; i++) {
            pq.offer(Long.parseLong(br.readLine()));
        }
        br.close();
        
        while (pq.size() > 1) {
            long curr = pq.poll() + pq.poll();
            answer += curr;
            pq.offer(curr);
            
        }
        System.out.println(answer);
    }

}