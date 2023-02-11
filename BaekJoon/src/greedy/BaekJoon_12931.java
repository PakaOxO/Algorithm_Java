package greedy;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_12931, 두 배 더하기 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_12931 {
    static int N, answer;
    static int[] arr;
    static Queue<Integer> qOdd, qEven;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N];
        qOdd = new LinkedList<>();
        qEven = new LinkedList<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 0) continue;
            else if (arr[i] % 2 == 0) qEven.offer(i);
            else qOdd.offer(i);
        }
        
        while (!qOdd.isEmpty() || !qEven.isEmpty()) {
            while (!qOdd.isEmpty()) {
                int idx = qOdd.poll();
                answer++;
                arr[idx]--;
                if (arr[idx] == 0) continue;
                else {
                    qEven.offer(idx);
                }
            }
            
            int size = qEven.size();
            if (size > 0) answer++;
            for (int i=0; i<size; i++) {
                int idx = qEven.poll();
                arr[idx] /= 2;
                if (arr[idx] % 2 == 0) {
                    qEven.offer(idx);
                } else {
                    qOdd.offer(idx);
                }
            }
        }
        System.out.println(answer);
    }

}
