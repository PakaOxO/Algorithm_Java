package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BaekJoon_17179, 케이크 자르기 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_17179 {
    static int N, M, L;
    static int[] cuttingPoint;
    static int[][] dp;
    
    static int cut(int left, int right, int res) {
        int len = 1;
        
        
        return len;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        cuttingPoint = new int[M];
        for (int i=0; i<M; i++) {
            cuttingPoint[i] = Integer.parseInt(br.readLine());
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            int Q = Integer.parseInt(br.readLine());
            if (Q % 2 == 1) {
                
            } else {
                
            }
        }
        System.out.println(sb);
    }

}
