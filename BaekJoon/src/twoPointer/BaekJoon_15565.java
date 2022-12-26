package twoPointer;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_15565, 귀여운 라이언
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_15565 {
    static int N, K, min;
    static int[] arr;
    static Deque<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        min = N + 1;
        for (int i=0; i<N; i++) {
            if (Integer.parseInt(st.nextToken()) != 1) continue;
            
            if (q.size() < K) {
                q.addLast(i);
            } else {
                q.removeFirst();
                q.addLast(i);
            }
            
            if (q.size() == K) min = Math.min(min, (q.peekLast() - q.peekFirst() + 1));
        }
        if (min > N)
            System.out.println(-1);
        else
            System.out.println(min);
    }

}
