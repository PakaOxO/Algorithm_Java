package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_14923_2, 미로 탈출
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_14923_2 {
    static class Pos {
        int r, c, z, depth;
        
        Pos(int r, int c, int z, int depth) {
            this.r = r;
            this.c = c;
            this.z = z;
            this.depth = depth;
        }
    }
    
    static int INF = Integer.MAX_VALUE >> 1;
    static int N, M, Hx, Hy, Ex, Ey, answer;
    static int[][] map;
    static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    
    static void bfs() {
        if (Hx == Ex && Hy == Ey) return;
        
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(Hx, Hy, 0, 0));
        boolean[][][] isVisited = new boolean[N][M][2];
        isVisited[Hx][Hy][0] = true;
        
        while (!q.isEmpty()) {
            Pos curr = q.poll();
            if (curr.r == Ex && curr.c == Ey) {
                answer = curr.depth;
                return;
            }
            
            for (int i=0; i<4; i++) {
                int nr = curr.r + drc[i][0];
                int nc = curr.c + drc[i][1];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || isVisited[nr][nc][curr.z]) continue;
                if (map[nr][nc] == 1 && curr.z == 1) continue;
                
                if (map[nr][nc] == 0) {
                    q.offer(new Pos(nr, nc, curr.z, curr.depth + 1));
                } else {
                    q.offer(new Pos(nr, nc, curr.z + 1, curr.depth + 1));
                }
                isVisited[nr][nc][curr.z] = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Hx = Integer.parseInt(st.nextToken()) - 1; Hy = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        Ex = Integer.parseInt(st.nextToken()) - 1; Ey = Integer.parseInt(st.nextToken()) - 1;
        
        map = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        
        answer = -1;
        bfs();
        System.out.println(answer);
    }

}
