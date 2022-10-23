package shortestPath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BaekJoon_1389, 케빈 베이컨의 6단계 법칙 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 결국 모든 사람들에 대한 최단 거리를 구해야하므로 플로이드-워셜 사용 
 *  3. 플로이드-워셜 로직이 종료되면 dist 배열을 순회하면서 각 시작 노드에 대해 케빈 베이컨 수를 계산하고 최소값과 비교해 최소값 및 최소 노드 갱신 
 *  4. 최소값을 가진 노드의 번호를 출력 
 *
 */
public class BaekJoon_1389 {
    static final int INF = Integer.MAX_VALUE >> 1;
    static int N, M;
    static boolean[][] adjArr;
    static int[][] dist;
    
    static void floydWarshall() {
        for (int k=1; k<=N; k++) {
            for (int i=1; i<=N; i++) {
                if (i == k) continue;
                for (int j=1; j<=N; j++) {
                    if (j == i || j == k) continue;
                    if (dist[i][j] <= dist[i][k] + dist[k][j]) continue;
                    dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());
       
       dist = new int[N + 1][N + 1];
       for (int[] d : dist) Arrays.fill(d, INF);
       for (int i=0; i<M; i++) {
           st = new StringTokenizer(br.readLine());
           int s = Integer.parseInt(st.nextToken());
           int e = Integer.parseInt(st.nextToken());
           dist[s][e] = 1;
           dist[e][s] = 1;
       }
       br.close();
       
       floydWarshall();
       int min = INF;
       int answer = -1;
       for (int i=1; i<=N; i++) {
           int sum = 0;
           for (int j=1; j<=N; j++) {
               if (i == j || dist[i][j] == INF) continue;
               sum += dist[i][j];
           }
           if (sum < min) {
               min = sum;
               answer = i;
           }
       }
       System.out.println(answer);
    }

}
