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
    static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    static int[][] tDir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }};
    static int[][] bDir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    
    static void diffusion() {
        for (int r=0; r<R; r++) {
            for (int c=0; c<C; c++) {
                if (map[r][c][0] <= 0) continue;
                
                int dCnt = 0;
                for (int j=0; j<4; j++) {
                    int nr = r + drc[j][0];
                    int nc = c + drc[j][1];
                    if (nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc][0] == -1) continue;
                    
                    map[nr][nc][1] += map[r][c][0] / 5;
                    dCnt++;
                }
                map[r][c][0] -= (map[r][c][0] / 5) * dCnt;
            }
        }
        
        for (int r=0; r<R; r++) {
            for (int c=0; c<C; c++) {
                if (map[r][c][1] == 0) continue;
                map[r][c][0] += map[r][c][1];
                map[r][c][1] = 0;
            }
        }
    }
    
    static void purifying() {
        int[] top = purifier.get(0);
        
        int[] prev = { top[0], top[1] };
        loop:
        for (int i=0; i<4; i++) {
            while (true) {
                int nr = prev[0] + tDir[i][0];
                int nc = prev[1] + tDir[i][1];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C || nr > top[0]) break;
                if (nr == top[0] && nc == top[1]) {
                    map[prev[0]][prev[1]][0] = 0;
                    break loop;
                }
                if (prev[0] == top[0] && prev[1] == top[1]) {
                    prev[0] = nr;
                    prev[1] = nc;
                    continue;
                }
                map[prev[0]][prev[1]][0] = map[nr][nc][0];
                prev[0] = nr;
                prev[1] = nc;
            }
        }
        
        int[] bottom = purifier.get(1);
        prev[0] =bottom[0];
        prev[1] = bottom[1];
        loop:
        for (int i=0; i<4; i++) {
            while (true) {
                int nr = prev[0] + bDir[i][0];
                int nc = prev[1] + bDir[i][1];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C || nr < bottom[0]) break;
                if (nr == bottom[0] && nc == bottom[1]) {
                    map[prev[0]][prev[1]][0] = 0;
                    break loop;
                }
                
                if (prev[0] == bottom[0] && prev[1] == bottom[1]) {
                    prev[0] = nr;
                    prev[1] = nc;
                    continue;
                }
                map[prev[0]][prev[1]][0] = map[nr][nc][0];
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
        
        for (int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<C; j++) {
                map[i][j][0] = Integer.parseInt(st.nextToken());
                if (map[i][j][0] == -1) {
                    purifier.add(new int[] { i, j });
                }
            }
        }
        br.close();
        
        while (T > 0) {
            diffusion();
            purifying();
            T--;
        }
        
        int answer = 0;
        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (map[i][j][0] <= 0) continue;
                answer += map[i][j][0];
            }
        }
        System.out.println(answer);
    }

}
