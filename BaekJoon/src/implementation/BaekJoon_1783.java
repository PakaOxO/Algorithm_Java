package implementation;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1783, 병든 나이트
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 조건에 따라 분기를 많이 둬야 하는 문제
 *  2. 4번 이상 움직일 수 있으려면 4가지 이동 모두를 써야하므로 N은 3이상 M은 7이상이어야 함
 *      2.1 4번 이상 움직일 수 있다면 나머지는 우측 벽에 닿을 때까지 이동하는 횟수와 같음
 *      2.2 4번 이상 움직일 수 없다면 최대 3번까지 아무 이동이나 선택해 이동할 수 있는 횟수의 최대값을 구하면 됨 -> DFS
 *  3. 결과 출력
 *
 */
public class BaekJoon_1783 {
    static int N, M, h, w, answer;
    static int[][] drc = { { 1, 2 }, { 2, 1 }, { -1, 2 }, { -2, 1 } };
    
    static void dfs(int h1, int w1, int depth) {
        if (depth == 4) return;
        answer = Math.max(answer, depth);
        
        for (int i=0; i<4; i++) {
            int nh = h1 + drc[i][0];
            int nw = w1 + drc[i][1];
            if (nh < 1 || nh > N || nw > M) continue;
            dfs(nh, nw, depth + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        if (N > 2 && M > 6) {
            answer = 5 + (M - 7);
        } else {
            dfs(1, 1, 0);
            answer++;
        }
        
        System.out.println(answer);
    }

}
