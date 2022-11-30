package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1926, 그림
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_1926 {
    static int N, M, area, cnt, max;
    static int[][] board;
    static Queue<int[]> pos;
    static boolean[][] isVisited;
    static int[][] drc = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    
    static void dfs(int r, int c) {
        if (area > max) {
            max = area;
        }
        
        for (int i=0; i<4; i++) {
            int nr = r + drc[i][0];
            int nc = c + drc[i][1];
            if (nr < 0 || nc < 0 || nr >= N || nc >= M || isVisited[nr][nc] || board[nr][nc] == 0) continue;
            isVisited[nr][nc] = true;
            area++;
            dfs(nr, nc);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        board = new int[N][M];
        isVisited = new boolean[N][M];
        pos = new LinkedList<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    pos.offer(new int[] { i, j });
                }
            }
        }
        
        while (!pos.isEmpty()) {
            int[] curr = pos.poll();
            if (isVisited[curr[0]][curr[1]]) continue;
            
            isVisited[curr[0]][curr[1]] = true;
            cnt++;
            area = 1;
            dfs(curr[0], curr[1]);
        }
        
        System.out.println(cnt);
        System.out.println(max);
    }

}
