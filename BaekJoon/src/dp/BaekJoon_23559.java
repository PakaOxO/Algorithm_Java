package dp;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_23559, 밥
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_23559 {
    static int N, X;
    static int[][] taste;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        
        taste = new int[N][2];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            taste[i][0] = Integer.parseInt(st.nextToken());
            taste[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(taste, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o2[0] - o2[1]) - (o1[0] - o1[1]);
            }
        });
        
        int max5 = (X - (N * 1000)) / 4000;
        long answer = 0;
        for (int i=0; i<N; i++) {
            if (taste[i][0] > taste[i][1] && max5 > 0) {
                answer += taste[i][0];
                max5--;
            } else {
                answer += taste[i][1];
            }
        }
        System.out.println(answer);
    }

}
