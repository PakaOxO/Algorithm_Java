package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BaekJoon_2167, 2차원 배열의 합 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_2167 {
    static int N, M;
    static int[][] acc;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        acc = new int[N + 1][M + 1];
        
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=M; j++) {
                acc[i][j] = acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1] + Integer.parseInt(st.nextToken());
            }
        }
        
        int T = Integer.parseInt(br.readLine());
        for (int tc=0; tc<T; tc++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()), c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken()), c2 = Integer.parseInt(st.nextToken());
            
            sb.append(acc[r2][c2] - (acc[r2][c1 - 1] + acc[r1 - 1][c2]) + acc[r1 - 1][c1 - 1]).append("\n");
        }
        
        System.out.println(sb);
    }

}
