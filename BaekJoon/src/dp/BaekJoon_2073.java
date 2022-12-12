package dp;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2073, 수도배관공사
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 현재까지의 조합 중 최대 값을 골라야 하지만 각각의 조합 요소에 대해서는 최소 값을 골라야 하는 문제..
 *  2. 위에 대한 처리를 해주는 부분이 생각보다 까다로웠음.
 *      2.1 먼저 조합에 대한 최소값은 현재 만드려는 길이를 만들기 위해 (목표 길이) - (현재 파이프 길이)의 위치에 대한 capacity 값과 현재 capacity를 비교해
 *          최소값을 해당 dp의 최소값으로 두는 데, 
 *
 */
public class BaekJoon_2073 {
    static int D, P;
    static long answer;
    static long[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        D = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        
        dp = new long[D + 1];
        for (int i=1; i<=P; i++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int cap = Integer.parseInt(st.nextToken());
            
            for (int j=D; j>len; j--) {
                if (dp[j - len] > 0) {
                    dp[j] = Math.max(dp[j], Math.min(dp[j - len], cap));
                }
            }
            answer = Math.max(answer, dp[D]);
            if (cap > dp[len]) {
                dp[len] = cap;
            }
        }
        
        System.out.println(answer);
    }

}
