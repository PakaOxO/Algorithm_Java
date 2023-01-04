package sort;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2696_2, 중앙값 구하기, 우선순위큐 사용 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_2696_2 {
    static int T, N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        T = Integer.parseInt(br.readLine());
        
        for (int tc=0; tc<T; tc++) {
            N = Integer.parseInt(br.readLine());
            sb.append(N / 2 + 1).append("\n");
            PriorityQueue<Integer> pq1 = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            PriorityQueue<Integer> pq2 = new PriorityQueue<>();
            for (int i=0; i<N; i++) {
                if (N % 10 == 0) st = new StringTokenizer(br.readLine());
                pq2.offer(Integer.parseInt(st.nextToken()));
                if (N % 2 == 0) {
                    if (pq1.size() > 0 && pq2.peek() < pq1.peek()) {
                        pq2.offer(pq1.poll());
                        pq1.offer(pq2.poll());
                    }
                } 
            }
            
        }
        System.out.println(sb.toString().trim());
    }

}
