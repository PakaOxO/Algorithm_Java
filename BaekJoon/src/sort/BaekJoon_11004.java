package sort;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_11004, K번째 수 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_11004 {
    static int N, K, answer;
    static Queue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) pq.offer(Integer.parseInt(st.nextToken()));
        for (int i=0; i<K - 1; i++) pq.poll();
        
        answer = pq.peek();
        System.out.println(answer);
    }

}
