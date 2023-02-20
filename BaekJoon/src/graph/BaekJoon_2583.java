package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2583, 영역 구하기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_2583 {
    static int N, M, K;
    static int[][] drc = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
    static boolean[][] board;
    static List<Integer> area = new ArrayList<>();
    
    static void bfs(int sR, int sC) {
        Queue<int[]> pos = new LinkedList<>();
        pos.offer(new int[] { sR, sC });
        board[sR][sC] = true;
        
        int size = 0;
        while (!pos.isEmpty()) {
            int[] curr = pos.poll();
            size++;
            for (int i=0; i<4; i++) {
                int nr = curr[0] + drc[i][0];
                int nc = curr[1] + drc[i][1];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc]) continue;
                pos.offer(new int[] { nr, nc });
                board[nr][nc] = true;
            }
        }
        area.add(size);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        board = new boolean[N][M];
        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int sR = Integer.parseInt(st.nextToken());
            int sC = Integer.parseInt(st.nextToken());
            int eR = Integer.parseInt(st.nextToken());
            int eC = Integer.parseInt(st.nextToken());
            
            for (int r=sR; r<eR; r++) {
                for (int c=sC; c<eC; c++) {
                    board[r][c] = true;
                }
            }
        }
        br.close();
        
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (!board[i][j]) {
                    bfs(i, j);
                }
            }
        }
        
        Collections.sort(area);
        StringBuilder sb = new StringBuilder();
        sb.append(area.size()).append("\n");
        for (int i=0; i<area.size(); i++) {
            sb.append(area.get(i)).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

}
