package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_10026, 적록색약
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 영역의 개수를 구하는 문제로 DFS나 BFS로 구분된 영역이 몇 개인제 체크하면 되는 문제
 *  2. 적록색약의 경우에는 R과 G을 동일한 문자로 보므로 조건문을 넣어 주어야 함
 *
 */
public class BaekJoon_10026 {
    static int N, cnt1, cnt2;
    static char[][] map;
    static boolean[][] isVisited1, isVisited2;
    
    static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    
    static void person1(int sR, int sC, char color) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { sR, sC });
        
        isVisited1[sR][sC] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            for (int i=0; i<4; i++) {
                int nr = curr[0] + drc[i][0];
                int nc = curr[1] + drc[i][1];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N || isVisited1[nr][nc] || map[nr][nc] != color) continue;
                q.offer(new int[] { nr, nc });
                isVisited1[nr][nc] = true;
            }
        }
        
    }
    
    static void person2(int sR, int sC, char color) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { sR, sC });
        
        isVisited2[sR][sC] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            for (int i=0; i<4; i++) {
                int nr = curr[0] + drc[i][0];
                int nc = curr[1] + drc[i][1];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N || isVisited2[nr][nc]) continue;
                if (color == 'B' && map[nr][nc] != color) continue;
                if (color != 'B' && map[nr][nc] == 'B') continue;
                
                q.offer(new int[] { nr, nc });
                isVisited2[nr][nc] = true;
            }
        }
        
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        map = new char[N][N];
        for (int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        br.close();
        
        isVisited1 = new boolean[N][N];
        isVisited2 = new boolean[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!isVisited1[i][j]) {
                    cnt1++;
                    person1(i, j, map[i][j]);
                }
                if (!isVisited2[i][j]) {
                    cnt2++;
                    person2(i, j, map[i][j]);
                }
            }
        }
        
        System.out.println(cnt1 + " " + cnt2);
    }

}
