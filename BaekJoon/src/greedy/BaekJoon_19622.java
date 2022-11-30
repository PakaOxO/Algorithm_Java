package greedy;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_19622, 회의실 배정 3
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 그리디하게 접근, 회의 시작이 빠르고, 빨리 끝나면서, 회의 인원이 많은 순서로 정렬
 *
 */
public class BaekJoon_19622 {
    static int N;
    static int[][] meetings;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        meetings = new int[N][3];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
            meetings[i][2] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            };
        });
        
        dp = new int[N];
        dp[0] = meetings[0][2];
        if (N > 1) dp[1] = Math.max(dp[0], meetings[1][2]);
        for (int i=2; i<N; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + meetings[i][2]);
        }
        
        System.out.println(dp[N - 1]);
    }

}
