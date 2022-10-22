package implementation;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_13460, 구슬 탈출 2
 * 
 * @author kevin-Arpe
 * 
 *         Sketch Idea
 *         1. 구슬 이동을 어떻게 구현..?
 *         1.1 BFS로 이동시키되 상하좌우 이동에 따라 우선순위 큐 우선 순위를 달리해 각각의 탐색을 구현 해보자
 *         1.2 각각의 이동에 대해 상 이동의 경우 위에 있는 구슬이 먼저 이동하게, 다른 이동도 이동 우선 순위가 이동 방향에
 *         달라지도록 각각 BFS 구현
 * 
 *         2. 각 페이즈 이동 선택은 DFS 탐색을 돌면서 10번 이내로 4방향 조합을 탐색하도록..?
 *         2.1 총 10번까지 가능한데 그럼 4^10 = 2^20 가능한가..? 100만개니까 일단 해보자
 *         2.2 만약 기울였는데 이동을 전혀 안했으면 기울인 의미가 없으니까 해당 페이즈는 자를 수 있겠다
 * 
 *         2.3 그럼 각 페이즈마다 구슬 이동을 하나? 원본 배열이 수정되면 골치아플텐데 -> 각각의 구슬 위치만 저장해서 위치 데이터만 수정하자 
 * 
 *
 */
public class BaekJoon_13460 {
    static class Pos {
        int r, c;
        char type;

        Pos(int r, int c, char type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }
    }

    static int N, M, rSr, rSc, bSr, bSc, answer;
    static char[][] board, copiedBoard;
    static Pos red, blue;
    static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 0, 1, 2, 3(상하좌우)

    static void dfs(int rR, int rC, int bR, int bC, int prevDir, int depth) {
        if (depth >= answer || depth > 10) return;

        for (int i = 0; i < 4; i++) {
            if (depth > 1 && i == prevDir) {
                continue;
            }
            
            int[] next = move(rR, rC, bR, bC, i);
            if (next[0] == rR && next[1] == rC && next[2] == bR && next[3] == bC) continue;
            if (next[3] == -1) continue;
            if (next[0] == -1) {
                answer = depth;
                continue;
            }
            dfs(next[0], next[1], next[2], next[3], i, depth + 1);
        }
    }

    static int[] move(int rR, int rC, int bR, int bC, int dir) {
        PriorityQueue<Pos> pq = null;
        switch (dir) {
            case 0:
                pq = new PriorityQueue<>(new Comparator<Pos>() {
                    @Override
                    public int compare(Pos o1, Pos o2) {
                        return o1.r - o2.r;
                    }
                });
                break;
            case 1:
                pq = new PriorityQueue<>(new Comparator<Pos>() {
                    @Override
                    public int compare(Pos o1, Pos o2) {
                        return o2.r - o1.r;
                    }
                });
                break;
            case 2:
                pq = new PriorityQueue<>(new Comparator<Pos>() {
                    @Override
                    public int compare(Pos o1, Pos o2) {
                        return o1.c - o2.c;
                    }
                });
                break;
            case 3:
                pq = new PriorityQueue<>(new Comparator<Pos>() {
                    @Override
                    public int compare(Pos o1, Pos o2) {
                        return o2.c - o1.c;
                    }
                });
                break;
        }
        pq.offer(new Pos(rR, rC, 'R'));
        pq.offer(new Pos(bR, bC, 'B'));

        while (!pq.isEmpty()) {
            Pos curr = pq.poll();
            int nr = curr.r + drc[dir][0];
            int nc = curr.c + drc[dir][1];

            if (board[nr][nc] == '#')
                continue;
            if (nr == bR && nc == bC)
                continue;
            if (nr == rR && nc == rC)
                continue;

            if (board[nr][nc] == '.') {
                pq.offer(new Pos(nr, nc, curr.type));
                if (curr.type == 'R') {
                    rR = nr;
                    rC = nc;
                } else {
                    bR = nr;
                    bC = nc;
                }
            } else if (board[nr][nc] == 'O') {
                if (curr.type == 'R') {
                    rR = -1;
                    rC = -1;
                } else {
                    bR = -1;
                    bC = -1;
                }
            }
        }
        return new int[] { rR, rC, bR, bC };
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    rSr = i;
                    rSc = j;
                    board[i][j] = '.';
                } else if (board[i][j] == 'B') {
                    bSr = i;
                    bSc = j;
                    board[i][j] = '.';
                }
            }
        }
        br.close();

        answer = Integer.MAX_VALUE;
        dfs(rSr, rSc, bSr, bSc, -1, 1);

        if (answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }

}
