package dp;

import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon_6506 {
    static int N, K;
    static int[] arr;
    static long[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (true) {
            input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            if (N == 0 && K == 0) break;
            
            input = br.readLine();
            st = new StringTokenizer(input);
            arr = new int[N];
            for (int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            dp = new long[N][K + 1];
            long count = 0;

            // 현재 위치
            for (int i = 0; i < N; i++) {
              dp[i][1] = 1;
              // 이전 위치들
              for (int j = 0; j < i; j++) {
                // 나보다 같거나 크면 증가하는 수열을 만들 수 없음
                if (arr[j] >= arr[i]) continue;
                // 이전 친구의 각 len 길이의 개수 = 내 len + 1 길이의 개수
                // 이전 친구의 개수는 최대 현재 나(i)까지의 길이를 넘을 수 없음
                for (int c = 1; c < i + 1 && c < K; c++) {
                  dp[i][c + 1] += dp[j][c];
                }
              }

              count += dp[i][K];
            }
            
            sb.append(count).append("\n");
        }
        
        System.out.println(sb.toString().trim());
        br.close();
    }

}
