package implementation;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_12100, 2042(Easy)
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 2042 게임을 하면서 완전탐색으로 모든 움직일 수 있는 경우의 수 체크 = 4^5 = 2^10 = 1024가지 
 *  
 *  2. 각각의 이동에 대해 BFS 탐색을 하되 먼저 움직여야 하는 블록부터 움직이면 됨 
 *      2.1 BFS 탐색에서 큐를 우선순위큐로 대신해 움직여야 하는 방향에 가장 가까운 블록부터 움직이게 로직을 구현 
 *      2.2 블록이 움직여서 합쳐졌으면 해당 페이즈에서 그 블록은 더 이상 합쳐질 수 없으므로 visited 처리 
 *      2.3 모든 블록이 움직일 수 있는 만큼 BFS를 돌림 (더 움직일 수 없으면 큐에 다시 넣지 않음) 
 *      
 *  3. 모든 이동을 수행하면서 이동하는 블록(또는 합쳐진 블록)의 숫자를 확인해 블록 숫자의 최대값을 answer에 갱신
 *  
 *  4. 블록이 1일 경우엔 이동이 발생하지 않으므로 블록의 숫자를 바로 answer에 넣도록 함(예외처리)
 *
 */
public class BaekJoon_12100 {

    static int N, answer;
    static int[][] board, copiedBoard;
    static boolean[][] isVisited;
    static int[] sel;
    static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    static void copyBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copiedBoard[i][j] = board[i][j];
            }
        }
    }

    static void move(int dir) {
        PriorityQueue<int[]> pq = null;
        switch (dir) {
            case 0:
                pq = new PriorityQueue<>(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[0] - o2[0];
                    }
                });
                break;
            case 1:
                pq = new PriorityQueue<>(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o2[0] - o1[0];
                    }
                });
                break;
            case 2:
                pq = new PriorityQueue<>(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[1] - o2[1];
                    }
                });
                break;
            case 3:
                pq = new PriorityQueue<>(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o2[1] - o1[1];
                    }
                });
                break;
        }

        isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (copiedBoard[i][j] == 0)
                    continue;
                pq.offer(new int[] { i, j });
            }
        }

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int nr = curr[0] + drc[dir][0];
            int nc = curr[1] + drc[dir][1];
            if (nr < 0 || nc < 0 || nr >= N || nc >= N || isVisited[nr][nc])
                continue;

            if (copiedBoard[nr][nc] == 0) {
                copiedBoard[nr][nc] = copiedBoard[curr[0]][curr[1]];
                copiedBoard[curr[0]][curr[1]] = 0;
                pq.offer(new int[] { nr, nc });
                
                answer = Math.max(answer, copiedBoard[nr][nc]);
            } else {
                if (copiedBoard[nr][nc] == copiedBoard[curr[0]][curr[1]]) {
                    copiedBoard[nr][nc] *= 2;
                    copiedBoard[curr[0]][curr[1]] = 0;
                    isVisited[nr][nc] = true;

                    answer = Math.max(answer, copiedBoard[nr][nc]);
                }
            }
        }
    }

    static void play() {
        copyBoard();

        for (int i = 0; i < 5; i++) {
            move(sel[i]);
        }
    }

    static void dfs(int depth, int prev, int prevCnt) {
        if (prevCnt > 2)
            return;

        if (depth == 5) {
            play();
            return;
        }

        // 0~4, 상하좌우
        for (int i = 0; i < 4; i++) {
            sel[depth] = i;
            if (i == prev)
                dfs(depth + 1, i, prevCnt + 1);
            else
                dfs(depth + 1, i, 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        copiedBoard = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        sel = new int[5];
        answer = N == 1 ? board[0][0] : 0;
        dfs(0, -1, 0);
        System.out.println(answer);
    }

}
