package dp;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_11054, 가장 긴 바이토닉 부분 수열
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 증가하는 부분 수열, 혹은 감소하는 부분 수열을 구하는 문제의 확장판
 *  2. dp로 접근하되 현재 내 위치보다 좌측에서 나보다 숫자가 작으면서 dp값이 가장 큰 값이 이전 증가하는 부분 수열의 최대길이
 *      2.1 (이전 증가하는 부분 수열의 최대길이) + 1 가 현재까지의 최대 길이
 *      2.2 바이토닉 구조를 하려면 반대 방향으로는 감소하는 부분 수열을 찾아야 하는데 그냥 반대 끝에서 시작하는 증가하는 부분 수열을 찾았음
 *
 */
public class BaekJoon_11054 {
    static int N, answer;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dp = new int[N + 2][2];
        for (int i=1; i<=N; i++) {
            // left
            int maxIdx = 0;
            for (int j=0; j<i; j++) {
                if (arr[j] < arr[i] && dp[j][0] >= dp[maxIdx][0]) {
                    maxIdx = j;
                }
            }
            dp[i][0] = dp[maxIdx][0] + 1;
            
            // right
            maxIdx = N + 1;
            for (int j=N+1; j>N+1-i; j--) {
                if (arr[j] < arr[N+1-i] && dp[j][1] >= dp[maxIdx][1]) {
                    maxIdx = j;
                }
            }
            dp[N+1-i][1] = dp[maxIdx][1] + 1;
        }
        
        for (int i=1; i<=N; i++) {
            answer = Math.max(answer, dp[i][0] + dp[i][1] - 1);
        }
        System.out.println(answer);
    }

}
