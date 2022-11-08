package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_14430, 자원 캐기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_14430 {
    static int N, M, answer;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=M; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = Math.max(map[i - 1][j], map[i][j - 1]) + num;
            }
        }
        br.close();
        
        System.out.println(map[N][M]);
    }

}
