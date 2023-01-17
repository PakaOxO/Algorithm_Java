package implementation;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_20056, 마법사 상어와 파이어볼
 * @author arpeg
 *
 */
public class BaekJoon_20056 {
    static class FireBall {
        int r, c, d, s, w;
        
        FireBall(int d, int s, int w) {
            this.d = d;
            this.s = s;
            this.w = w;
        }
        
        FireBall(int r, int c, int d, int s, int w) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.s = s;
            this.w = w;
        }

        @Override
        public String toString() {
            return "FireBall [r=" + r + ", c=" + c + ", d=" + d + ", s=" + s + ", w=" + w + "]";
        }
    }
    
    static int N, M, K, totalCnt;
    static int[][][] map;
    static Queue<FireBall> balls = new LinkedList<>();
    static int[][] drc = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
    
    static void magic() {
        int ballCnt = balls.size();
        while (ballCnt > 0) {
            FireBall ball = balls.poll();
            int nr = ball.r;
            int nc = ball.c;
            nr += drc[ball.d][0] * ball.s;
            nc += drc[ball.d][1] * ball.s;
            if (nr < 1 || nc < 1 || nr > N || nc > N) continue;
            
            map[nr][nc][0] += ball.s;
            map[nr][nc][1] += ball.w;
            map[nr][nc][2]++;
            if (ball.s % 2 == 0) map[nr][nc][3] = 1;
            
            balls.offer(new FireBall(nr, nc, ball.d, ball.s, ball.w));
            ballCnt--;
        }
        
        merge();
    }
    
    static void merge() {
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if (map[i][j][2] == 0) continue;
                if (map[i][j][2] > 1) {
                    int newWeight = map[i][j][1] / 5;
                    if (newWeight > 0) {
                        int newSpeed = map[i][j][0] / map[i][j][2];
                        if (map[i][j][3] == 0) {
                            balls.offer(new FireBall(i, j, 0, newSpeed, newWeight));
                            balls.offer(new FireBall(i, j, 2, newSpeed, newWeight));
                            balls.offer(new FireBall(i, j, 4, newSpeed, newWeight));
                            balls.offer(new FireBall(i, j, 6, newSpeed, newWeight));
                        } else {
                            balls.offer(new FireBall(i, j, 1, newSpeed, newWeight));
                            balls.offer(new FireBall(i, j, 3, newSpeed, newWeight));
                            balls.offer(new FireBall(i, j, 5, newSpeed, newWeight));
                            balls.offer(new FireBall(i, j, 7, newSpeed, newWeight));
                        }
                    };
                }
                map[i][j][0] = 0;
                map[i][j][1] = 0;
                map[i][j][2] = 0;
                map[i][j][3] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new int[N + 1][N + 1][4];
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            balls.offer(new FireBall(r, c, d, s, m));
        }
        
        while (K > 0) {
            magic();
            K--;
        }
        
        int answer = 0;
        while (balls.size() > 0) {
            FireBall ball = balls.poll();
            answer += ball.w;
            System.out.println(ball);
        }
        System.out.println(answer);
    }

}
