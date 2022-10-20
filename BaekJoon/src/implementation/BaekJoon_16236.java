package implementation;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_16236, 아기 상어
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_16236 {
    static class Shark {
        int size, r, c;
    }
    
    static int N, cnt, time;
    static int[][] map;
    static boolean[][] isVisited;
    static int[][] drc = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
    static Shark s = new Shark();
    
    static boolean bfs(int sR, int sC) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { sR, sC, 0 });
        
        isVisited = new boolean[N][N];
        isVisited[sR][sC] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            for (int i=0; i<4; i++) {
                int nr = curr[0] + drc[i][0];
                int nc = curr[1] + drc[i][1];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N || isVisited[nr][nc]) continue;
                
                if (map[nr][nc] == 0) {
                    q.offer(new int[] { nr, nc, curr[2] + 1 });
                    isVisited[nr][nc] = true;
                } else {
                    if (s.size < map[nr][nc]) continue;
                    
                    if (s.size == map[nr][nc]) {
                        q.offer(new int[] { nr, nc, curr[2] + 1 });
                        isVisited[nr][nc] = true;
                    } else {
                        s.r = nr;
                        s.c = nc;
                        cnt--;
                        time += curr[2] + 1;
                        map[nr][nc] = 0;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    s.r = i;
                    s.c = j;
                }
            }
        }
        br.close();
        
        s.size = 2;
        cnt = 2;
        map[s.r][s.c] = 0; 
        while (true) {
            boolean flag = bfs(s.r, s.c);
            if (!flag) break;
            if (cnt == 0) {
                s.size++;
                cnt = s.size;
            }
        }
        
        System.out.println(time);
    }

}
