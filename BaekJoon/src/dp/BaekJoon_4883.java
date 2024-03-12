package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BaekJoon_4883, 삼각 그래
 *  - 문제 분류: 다이나믹 프로그래밍 
 */
public class BaekJoon_4883 {
    static int N;
    static int[][] map, dp;
    static int INF = 1000 * 100000;
    
    static void getDp(int r, int c) {
        dp[0][0] = INF;
        dp[0][1] = map[0][1];
        dp[0][2] = map[0][1] + map[0][2];
        
        for (int i=1; i<N; i++) {
            for (int j=0; j<3; j++) {
                if (j == 0) {
                    dp[i][j] = map[i][j] + Math.min(dp[i - 1][0], dp[i - 1][1]);
                } else if (j == 1) {
                    dp[i][j] = map[i][j] + Math.min(dp[i][0], Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2])));
                } else {
                    dp[i][j] = map[i][j] + Math.min(dp[i][1], Math.min(dp[i - 1][1], dp[i - 1][2]));
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder("");
        int T = 1;
        
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0) break;
            
            map = new int[N][3];
            dp = new int[N][3];
            
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<3; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = INF;
                }
            }
            
            getDp(N - 1, 1);
            sb.append(T + ". " + dp[N - 1][1] + "\n");
            T++;
        }
        
        System.out.println(sb.toString().trim());
    }

}
