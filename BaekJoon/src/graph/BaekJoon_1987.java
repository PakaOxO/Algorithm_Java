package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1987, 알파벳
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_1987 {
    static int R, C, answer;
    static char[][] board;
    static boolean[] isVisited;
    static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    
    static void dfs(int r, int c, int depth) {
        answer = Math.max(answer, depth);
        
        for (int i=0; i<4; i++) {
            int nr = r + drc[i][0];
            int nc = c + drc[i][1];
            if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
            
            int idx = (int)(board[nr][nc] - 'A');
            if (isVisited[idx]) continue;
            
            isVisited[idx] = true;
            dfs(nr, nc, depth + 1);
            isVisited[idx] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        board = new char[R][C];
        for (int i=0; i<R; i++) {
            board[i] = br.readLine().toCharArray();
        }
        br.close();
        
        isVisited = new boolean[26];
        isVisited[(int)(board[0][0] - 'A')] = true;
        dfs(0, 0, 1);
        System.out.println(answer);
    }

}
