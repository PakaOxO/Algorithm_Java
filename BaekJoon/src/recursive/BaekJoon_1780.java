package recursive;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1780, 종이의 개수 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 먼저 종이가 같은 숫자로 이루어져 있는지 체크 
 *      1.1 같은 숫자로 이루어져 있으면 해당 숫자의 카운트를 늘려줌 
 *      1.2 같은 숫자로 이루어져 있지 않으면 가로-세로 3등분해 9개의 동일한 크기의 종이로 쪼개주고 각각의 종이에 대해 1단계부터 실행 
 *  2. 모든 재귀 호출이 종료되면 각각의 카운트를 정답을 출력할 문자열에 담아 출력 
 *
 */
public class BaekJoon_1780 {
    static int N;
    static int[][] board;
    static int[] cnt;
    
    static boolean check(int sR, int sC, int size) {
        int prev = board[sR][sC];
        for (int i=sR; i<sR+size; i++) {
            for (int j=sC; j<sC+size; j++) {
                if (prev != board[i][j]) return false;
            }
        }
        if (prev == -1) cnt[0]++;
        else if (prev == 0) cnt[1]++;
        else cnt[2]++;
        
        return true;
    }
    
    static void dfs(int sR, int sC, int size) {
        if (size == 0) return;
        
        boolean flag = check(sR, sC, size);
        if (flag) return;
        
        int nSize = size / 3;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                dfs(sR + (nSize * i), sC + (nSize * j), nSize);
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        cnt = new int[3];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
        
        dfs(0, 0, N);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d\n%d\n%d", cnt[0], cnt[1], cnt[2]));
        System.out.println(sb);
    }

}
