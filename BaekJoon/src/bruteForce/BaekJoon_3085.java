package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BaekJoon_3085, 사탕 게임
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_3085 {
    static int N, max;
    static char[][] arr;
    static int[][] drc1 = { { 0, 1 }, { 1, 0 } };
    static int[][] drc2 = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
    
    static void check(int r, int c) {
        int rCnt = 0;
        int cCnt = 0;
        
        char rPrev = arr[r][0];
        char cPrev = arr[0][c];
        for (int i=0; i<N; i++) {
            if (arr[r][i] == rPrev) {
                rCnt++;
            } else {
                rCnt = 1;
            }
            
            if (arr[i][c] == cPrev) {
                cCnt++;
            } else {
                cCnt = 1;
            }
            
            max = Math.max(max, rCnt);
            max = Math.max(max, cCnt);
            rPrev = arr[r][i];
            cPrev = arr[i][c];
        }
    }
    
    static void swap(int r1, int c1, int r2, int c2) {
        char temp = arr[r1][c1];
        arr[r1][c1] = arr[r2][c2];
        arr[r2][c2] = temp;
    }
    
    static void solution() {
        for (int i=0; i<N; i++) {
            int rCnt = 0;
            int cCnt = 0;
            int rPrev = arr[i][0];
            int cPrev = arr[0][i];
            for (int j=0; j<N; j++) {
                if (arr[i][j] == rPrev) {
                    rCnt++;
                } else {
                    rCnt = 1;
                }
                
                if (arr[j][i] == cPrev) {
                    cCnt++;
                } else {
                    cCnt = 1;
                }
                
                for (int k=0; k<2; k++) {
                    int nr = i + drc1[k][0];
                    int nc = j + drc1[k][1];
                    if (nr == N || nc == N || arr[i][j] == arr[nr][nc]) continue;
                    swap(i, j, nr, nc);
                    check(i, j);
                    check(nr, nc);
                    swap(i, j, nr, nc);
                }
                
                max = Math.max(max, rCnt);
                max = Math.max(max, cCnt);
                rPrev = arr[i][j];
                cPrev = arr[j][i];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        arr = new char[N][N];
        for (int i=0; i<N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        solution();
        System.out.println(max);
    }

}
