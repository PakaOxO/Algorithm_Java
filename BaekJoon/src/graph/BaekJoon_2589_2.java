package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2589_2, 보물섬 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_2589_2 {
    static int L, W, max;
    static char[][] map;
    static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    
    static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[L][W];
        
        q.offer(new int[] { r, c, 0 });
        isVisited[r][c] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            max = Math.max(max, curr[2]);
            
            for (int i=0; i<4; i++) {
                int nr = curr[0] + drc[i][0];
                int nc = curr[1] + drc[i][1];
                if (nr < 0 || nc < 0 || nr >= L || nc >= W || map[nr][nc] != 'L' ||isVisited[nr][nc]) continue;
                q.offer(new int[] { nr, nc, curr[2] + 1 });
                isVisited[nr][nc] = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        
        map = new char[L][W];
        for (int i=0; i<L; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        for (int i=0; i<L; i++) {
            for (int j=0; j<W; j++) {
                if (map[i][j] != 'L') continue;
                bfs(i, j);
            }
        }
        System.out.println(max);
    }

}
