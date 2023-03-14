package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_11123, 양 한마리... 양 두마리... 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_11123 {
    static int N, M, answer;
    static char[][] map;
    static boolean[][] isVisited;
    static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    
    static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { r, c });
        isVisited[r][c] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int i=0; i<4; i++) {
                int nr = curr[0] + drc[i][0];
                int nc = curr[1] + drc[i][1];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M || isVisited[nr][nc] || map[nr][nc] == '.') continue;
                q.offer(new int[] { nr, nc });
                isVisited[nr][nc] = true;
            }
        }
        answer++;
    }
    
    static void dfs(int r, int c) {
        for (int i=0; i<4; i++) {
            int nr = r + drc[i][0];
            int nc = c + drc[i][1];
            if (nr < 0 || nc < 0 || nr >= N || nc >= M || isVisited[nr][nc] || map[nr][nc] == '.') continue;
            isVisited[nr][nc] = true;
            dfs(nr, nc);
        }
    }

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc=0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            isVisited = new boolean[N][M];
            for (int i=0; i<N; i++) {
                map[i] = br.readLine().toCharArray();
            }
            answer = 0;
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (map[i][j] == '.' || isVisited[i][j]) continue;
                    isVisited[i][j] = true;
                    dfs(i, j);
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
