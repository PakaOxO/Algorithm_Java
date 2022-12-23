package twoPointer;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2003, 수들의 합 2
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_2003 {
    static int N, M, answer;
    static long[] acc;
    static Map<Long, Integer> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        acc = new long[N];
        map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            if (i == 0) {
                acc[i] = Integer.parseInt(st.nextToken());
            } else {
                acc[i] = acc[i - 1] + Integer.parseInt(st.nextToken());
            }
            map.put(acc[i], i);
            
            if (acc[i] >= M) {
                if (acc[i] == M) answer++;
                else {
                    if (map.containsKey(acc[i] - M))
                        answer++;
                }
            }
        }
        System.out.println(answer);
    }

}
