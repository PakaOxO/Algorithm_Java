package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_17471, 게리맨더링
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 각 두 선거구를 나누는 방법을 먼저 조합으로 찾은 뒤 각각의 선거구가 서로 연결되어 있는지 체크
 *  2. 비트마스킹으로 모든 조합을 먼저 찾은 뒤 각각의 구역에 대해 BFS 탐색을 돌면서 연결된 개수를 체크
 *     2.1 선거구의 개수와 연결된 개수가 같으면 모두 인접한 것이므로 두 선거구가 모두 조건을 만족할 때 인구 차이 계산
 *
 */
public class BaekJoon_17471 {
    static int V, answer;
    static int[] population, district;
    static boolean[][] adjArr;
    
    static int connected(int s, int d) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        
        boolean[] isVisited = new boolean[V];
        isVisited[s] = true;
        
        int cnt = 1;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i=0; i<V; i++) {
                if (isVisited[i] || curr == i || district[i] != d || !adjArr[curr][i]) continue;
                q.offer(i);
                isVisited[i] = true;
                cnt++;
            }
        }
        
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        
        population = new int[V];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<V; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }
        
        adjArr = new boolean[V][V];
        for (int i=0; i<V; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j=0; j<cnt; j++) {
                int e = Integer.parseInt(st.nextToken()) - 1;
                adjArr[i][e] = true;
                adjArr[e][i] = true;
            }
        }
        br.close();
        
        answer = Integer.MAX_VALUE;
        for (int i=1; i<(1 << V - 1); i++) {
            int cntA = 0;
            int cntB = 0;
            district = new int[V];
            
            int sA = -1;
            int sB = -1;
            for (int j=0; j<V; j++) {
                if ((i & (1 << j)) > 0) {
                    district[j] = 1;
                    cntA++;
                    sA = j;
                } else {
                    district[j] = 2;
                    cntB++;
                    sB = j;
                }
            }
            
            if (connected(sA, 1) == cntA && connected(sB, 2) == cntB) {
                int sumA = 0;
                int sumB = 0;
                for (int j=0; j<V; j++) {
                    if (district[j] == 1) sumA += population[j];
                    else sumB += population[j];
                }
                answer = Math.min(answer, Math.abs(sumA - sumB));
            }
        }
        
        
        if (answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }

}
