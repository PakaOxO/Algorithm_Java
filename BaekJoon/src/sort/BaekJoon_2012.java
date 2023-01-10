package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * BaekJoon_2012, 등수 매기기 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_2012 {
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        for (int i=0; i<N; i++) pq.offer(Integer.parseInt(br.readLine()));
        long answer = 0;
        for (int i=1; i<=N; i++) {
            answer += Math.abs(i - pq.poll());
        }
        System.out.println(answer);
    }

}
