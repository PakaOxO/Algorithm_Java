package backtracking;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_5638, 수문 
 *  - 문제 분류 : 완전탐색, 백트래킹  
 */
public class BaekJoon_5638 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Gate[] gates = new Gate[N];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int flow = Integer.parseInt(st.nextToken());
            int damage = Integer.parseInt(st.nextToken());
            gates[i] = new Gate(flow, damage);
        }
        
        Solution_수문 s = new Solution_수문();
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc=0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int total = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            
            answer.append(s.solution(N, tc, total, time, gates)).append("\n");
        }
        
        System.out.println(answer.toString().trim());
        br.close();
    }
}

class Solution_수문 {
    Gate[] maxFlowGates;
    long answer;
    long INF = Long.MAX_VALUE;
    int N, total;
    
    int[] comb;
    
    String solution(int n, int tc, int total, int time, Gate[] gates) {
        /* 변수 초기화 */
        StringBuilder sb = new StringBuilder();
        this.N = n;
        this.total = total;
        comb = new int[n];
        Arrays.fill(comb, -1);
        
        /* 메인 로직 */
        maxFlowGates = new Gate[N];
        for (int i=0; i<n; i++) {
            long maxFlow = gates[i].flow * time;
            maxFlowGates[i] = new Gate(maxFlow, gates[i].damage);
        }
        
        answer = INF;
        dfs(0, 0, 0, 0);
        
        sb.append("Case ").append(tc + 1).append(": ").append(answer == INF ? "IMPOSSIBLE" : answer);
        
        /* 결과 반환 */
        return sb.toString();
    }
    
    /**
     * 선택할 수 있는 수문 완전 탐색 
     */
    void dfs(int start, int depth, long sum, long price) {
        if (price >= answer) return;
        if (sum >= total) {
            answer = Math.min(answer, price);
            return;
        }
        if (depth == N) return;
        
        for (int i=start; i<N; i++) {
            comb[depth] = i;
            dfs(i + 1, depth + 1, sum + maxFlowGates[i].flow, price + maxFlowGates[i].damage);
            comb[depth] = -1;
        }
    }
}

class Gate {
    long flow, damage;
    
    Gate(long flow, long damage) {
        this.flow = flow;
        this.damage = damage;
    }
}
