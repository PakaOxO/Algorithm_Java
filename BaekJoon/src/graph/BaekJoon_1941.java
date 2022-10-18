package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1941, 소문난 칠공주
 * @author kevin-Arpe
 *
 */
public class BaekJoon_1941 {
    static char[][] map;
    static int[][] sel;
    static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    static boolean[][] isVisited;
    static int answer;
    
    static boolean check(int r, int c) {
        boolean flag = false;
        for (int i=0; i<4; i++) {
            int nr = r + drc[i][0];
            int nc = c + drc[i][1];
            if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5) continue;
            if (isVisited[nr][nc]) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    
    static void dfs(int sCnt, int yCnt, int start, int depth) {
        if (depth == 7) {
            answer++;
            System.out.println(sCnt + yCnt);
            return;
        }
        
        for (int i=start; i<25; i++) {
            int r = i / 5;
            int c = i % 5;
            char type = map[r][c];
            if (type == 'Y' && yCnt == 3) continue;
            if (sCnt + yCnt > 0 && !check(r, c)) continue;
            
            sel[depth][0] = r;
            sel[depth][1] = c;
            isVisited[r][c] = true;
            if (type == 'Y') dfs(sCnt, yCnt + 1, start + 1, depth + 1);
            else dfs(sCnt + 1, yCnt, start + 1, depth + 1);
            isVisited[r][c] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        map = new char[5][5];
        for (int i=0; i<5; i++) {
            map[i] = br.readLine().toCharArray();
        }
        br.close();
        
        isVisited = new boolean[5][5];
        sel = new int[7][2];
        dfs(0, 0, 0, 0);
        
        System.out.println(answer);
    }

}
