package shortestPath;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_25688, 빠른 무작위 숫자 
 *  - 문제 분류 : 최단 거리, 다익스트라 
 */
public class BaekJoon_25688 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 5;
        int[][] map = new int[N][N];
        int[][] pos = new int[7][2];
        
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) {
                    pos[map[i][j]][0] = i;
                    pos[map[i][j]][1] = j;
                }
            }
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());
        pos[0][0] = sr;
        pos[0][1] = sc;
        
        Solution_빠른무작위숫자 s = new Solution_빠른무작위숫자();
        System.out.println(s.solution(N, map, pos));
    }

}

class Solution_빠른무작위숫자 {
    int n, m;
    int map[][];
    int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int [][] dist;
    boolean[] visited;
    int INF = Integer.MAX_VALUE;
    int answer = INF;
    
    int solution(int n, int[][] map, int[][] pos) {
        /* 변수 초기화 */
        this.n = n;
        this.m = 7;
        this.map = map;
        dist = new int[m][m];
        visited = new boolean[m];
        
        /* 메인 로직 */
        for (int i=0; i<m; i++) {
            for (int j=0; j<m; j++) {
                if (i == j) {
                    dist[i][i] = 0;
                    continue;
                }
                dist[i][j] = INF;
                bfs(pos[i][0], pos[i][1], pos[j][0], pos[j][1]);
            }
        }
        
        visited[0] = true;
        dfs(0, 0, 1);
        answer = answer == INF ? -1 : answer;
        
        /* 결과 반환 */
        return answer;
    }
    
    /**
     * 시작 지점(sr, sc)에서 끝 지점까지의 최단 거리 반환(er, ec)
     */
    void bfs(int sr, int sc, int er, int ec) {
        Queue<int[]> q = new LinkedList<int[]>();
        int[][] d = new int[n][n];
        for (int i=0; i<n; i++) {
            Arrays.fill(d[i], INF);
        }
        
        q.offer(new int[] { sr, sc, 0 });
        d[sr][sc] = 0;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int i=0; i<drc.length; i++) {
                int nr = curr[0] + drc[i][0];
                int nc = curr[1] + drc[i][1];
                if (nr < 0 || nc < 0 || nr >= n || nc >= n || map[nr][nc] < 0) continue;
                if (curr[2] + 1 >= d[nr][nc]) continue;
                if (nr == er && nc == ec) {
                    dist[map[sr][sc]][map[er][ec]] = curr[2] + 1;
                    return;
                }
                d[nr][nc] = curr[2] + 1;
                q.offer(new int[] { nr, nc, d[nr][nc] });
            }
        }
    }
    
    /**
     * 시작 지점부터 시작해 방문 정점의 개수가 m개가 될 때까지 최단거리 탐색  
     */
    void dfs(int s, int d, int depth) {
        if (d >= answer) return;
        if (depth == m) {
            answer = Math.min(answer, d);
            return;
        }
        
        for (int i=0; i<m; i++) {
            if (visited[i] || dist[s][i] == INF) continue;
            visited[i] = true;
            dfs(i, d + dist[s][i], depth + 1);
            visited[i] = false;
        }
    }
}