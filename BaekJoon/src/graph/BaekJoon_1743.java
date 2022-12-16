package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1743, 음식물 피하기
 * @author arpeg
 *
 */
public class BaekJoon_1743 {
    static int N, M, K, answer;
    static char[][] map;
    static boolean[][] isVisited;
    static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    static List<int[]> trash = new ArrayList<>();
    static Queue<int[]> q = new LinkedList<>();
    
    static void bfs(int sx, int sy) {
        q.offer(new int[] { sx, sy });
        isVisited[sx][sy] = true;
        
        int cnt = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            cnt++;
            for (int i=0; i<4; i++) {
                int nr = curr[0] + drc[i][0];
                int nc = curr[1] + drc[i][1];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M || isVisited[nr][nc] || map[nr][nc] == '.') continue;
                isVisited[nr][nc] = true;
                q.offer(new int[] { nr, nc });
            }
        }
        answer = Math.max(answer, cnt);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new char[N][M];
        isVisited = new boolean[N][M];
        for (char[] m : map) Arrays.fill(m, '.');
        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = '#';
            trash.add(new int[] { x, y });
        }
        
        for (int i=0; i<trash.size(); i++) {
            int[] pos = trash.get(i);
            if (isVisited[pos[0]][pos[1]]) continue;
            bfs(pos[0], pos[1]);
        }
        System.out.println(answer);
    }

}
