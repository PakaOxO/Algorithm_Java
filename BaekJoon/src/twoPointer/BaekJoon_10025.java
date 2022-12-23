package twoPointer;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_10025, 게으른 백곰
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_10025 {
    static class Pos implements Comparable<Pos> {
        int x, g;
        
        Pos(int g, int x) {
            this.g = g;
            this.x = x;
        }

        @Override
        public int compareTo(Pos o) {
            return this.x - o.x;
        }
    }
    
    static int N, K;
    static long answer;
    static Pos[] buckets;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        buckets = new Pos[N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            buckets[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(buckets);
        
        int left = 0;
        int right = 0;
        long sum = buckets[left].g;
        while (true) {
            if (buckets[right].x - buckets[left].x < K * 2) {
                right++;
                if (right == N) break;
                sum += buckets[right].g;
            } else {
                sum -= buckets[left].g;
                left++;
            }
            
            if (buckets[right].x - buckets[left].x <= K * 2)
                answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }

}
