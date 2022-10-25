package greedy;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1946, 신입사원
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_1946 {
    static int N;
    static int[] score;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int tc=1; tc<=T; tc++) {
            N = Integer.parseInt(br.readLine());
            
            score = new int[N + 1];
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                score[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }
            
            int min = score[1];
            int answer = N;
            for (int i=2; i<=N; i++) {
                if (score[i] > min) answer--;
                if (score[i] < min) min = score[i];
            }
            sb.append(answer).append("\n");
        }
        br.close();
        System.out.print(sb);
    }

}
