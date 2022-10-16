package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1012, 유기농 배추
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. M X N 크기의 밭을 탐색하면서 배추의 위치를 만나고 해당 배추를 방문한 적이 없으면 BFS 탐색
 *      1.1 탐색하면서 탐색한 배추는 visited 처리
 *  2. BFS 탐색을 몇 번 했는지 체크하면 뭉쳐져 있는 배추의 그룹 개수를 얻을 수 있음.
 *
 */
public class BaekJoon_1012 {
    static int N, M, K, answer;
    static int[][] map, pos;
    static boolean[][] isVisited;
    static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    
    static void bfs(int sR, int sC) {
        answer++;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { sR, sC });
        isVisited[sR][sC] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            for (int i=0; i<4; i++) {
                int nr = curr[0] + drc[i][0];
                int nc = curr[1] + drc[i][1];
                
                if (nr < 0 || nc < 0 || nr >= N || nc >= M || isVisited[nr][nc] || map[nr][nc] == 0) continue;
                q.offer(new int[] { nr, nc });
                isVisited[nr][nc] = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int tc=1; tc<=T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            map = new int[N][M];
            pos = new int[K][2];
            for (int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                map[r][c] = 1;
                pos[i][0] = r;
                pos[i][1] = c;
            }
            
            answer = 0;
            isVisited = new boolean[N][M];
            for (int i=0; i<K; i++) {
                int[] curr = pos[i];
                if (isVisited[curr[0]][curr[1]]) continue;
                bfs(curr[0], curr[1]);
            }
            sb.append(answer).append("\n");
        }
        br.close();
        System.out.print(sb);
    }

}
