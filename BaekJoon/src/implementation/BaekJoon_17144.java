package implementation;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_17144, 미세먼지 안녕! 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 문제에서 주어진 과정대로 구현하면 되는 문제
 *      1.1 공기청정기의 순환을 문제에서 주어진 방향 반대로 돌리면서 먼저 공기청정기로 빨려들어가는 공기 위치부터 반복문 실행해서 다음 공기 위치를 당겨 옴 
 *
 */
public class BaekJoon_17144 {
    static int R, C, T;
    static int[][][] map;
    static List<int[]> purifier;
    static Queue<int[]> dust;
    static boolean[][] hasDust;
    static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    static int[][] tDir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }};
    static int[][] bDir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    
    static void diffusion() {
        int cnt = dust.size();
        
        for (int i=0; i<cnt; i++) {
            int[] curr = dust.poll();
            int dCnt = 0;
            for (int j=0; j<4; j++) {
                int nr = curr[0] + drc[j][0];
                int nc = curr[1] + drc[j][1];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                
                map[nr][nc][1] += map[curr[0]][curr[1]][0] / 5;
                if (!hasDust[nr][nc]) {
                    dust.offer(new int[] { nr, nc });
                    hasDust[nr][nc] = true;
                }
                dCnt++;
            }
            map[curr[0]][curr[1]][0] -= map[curr[0]][curr[1]][0] / 5 * dCnt;
        }
        
        cnt = dust.size();
        for (int i=0; i<cnt; i++) {
            int[] curr = dust.poll();
            map[curr[0]][curr[1]][0] += map[curr[0]][curr[1]][1];
            map[curr[0]][curr[1]][1] = 0;
            dust.offer(curr);
        }
    }
    
    static void purifying() {
        int[] top = purifier.get(0);
        int[] bottom = purifier.get(1);
        
        int[] prev = { top[0], top[1] };
        loop:
        for (int i=0; i<4; i++) {
            while (true) {
                int nr = prev[0] + tDir[i][0];
                int nc = prev[1] + tDir[i][1];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C) break;
                if (nr == top[0] && nc == top[1]) break loop;
                
                if (prev[0] == top[0] && prev[1] == top[1]) {
                    prev[0] = nr;
                    prev[1] = nc;
                    continue;
                }
                map[prev[0]][prev[1]] = map[nr][nc];
                prev[0] = nr;
                prev[1] = nc;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        map = new int[R][C][2];
        purifier = new ArrayList<>();
        dust = new LinkedList<>();
        hasDust = new boolean[R][C];
        
        for (int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<C; j++) {
                map[i][j][0] = Integer.parseInt(st.nextToken());
                if (map[i][j][0] == -1) {
                    purifier.add(new int[] { i, j });
                } else if (map[i][j][0] != 0) {
                    dust.offer(new int[] { i, j });
                    hasDust[i][j] = true;
                }
            }
        }
        
        while (T > 0) {
            diffusion();
            purifying();
            T--;
        }
    }

}
