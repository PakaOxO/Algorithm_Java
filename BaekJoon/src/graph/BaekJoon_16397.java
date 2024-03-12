package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BaekJoon_16397, 탈출
 *  - 문제 분류: bfs
 */
public class BaekJoon_16397 {
    static int N, T, G;
    static int INF = 99999;
    static int[] dp = new int[INF + 1];
    
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        dp[start] = 0;
        q.offer(start);
        
        while (q.size() > 0) {
            int curr = q.poll();
            if (curr * 2 <= INF && curr != 0) {
                int copy = curr * 2;
                int len = 0;
                while (copy / (int)Math.pow(10, len) > 0) {
                    len++;
                }
                copy -= Math.pow(10, len - 1);
                
                if (dp[copy] > dp[curr] + 1) {
                    dp[copy] = dp[curr] + 1;
                    q.offer(copy);
                }
            }
            
            if (curr + 1 <= INF && dp[curr + 1] > dp[curr] + 1) {
                dp[curr + 1] = dp[curr] + 1;
                q.offer(curr + 1);
            }
        }
        
    }
    
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       
       // 변수 초기화 
       N = Integer.parseInt(st.nextToken());
       T = Integer.parseInt(st.nextToken());
       G = Integer.parseInt(st.nextToken());
       for (int i=0; i<=INF; i++) dp[i] = T + 1;
       
       // 메인 로직 
       bfs(N);
       
       if (dp[G] > T) {
           System.out.println("ANG");
       } else {
           System.out.println(dp[G]);
       }
    }
}
