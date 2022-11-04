package recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BaekJoon_2448, 별 찍기-11
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 크게 어렵지 않은 재귀문제
 *  2. char 배열의 기본값은 공백이 아니라 널이기 때문에 한번 틀렸었음...
 *
 */
public class BaekJoon_2448 {
    static int N, k, R, C;
    static char[][] arr;
    static void getTriangle(int depth) {
        if (depth > k) return;
        
        if (depth == 0) {
            arr[0][C / 2] = '*';
            arr[1][C / 2 - 1] = arr[1][C / 2 + 1] = '*';
            arr[2][C / 2 - 2] = arr[2][C / 2 - 1] = arr[2][C / 2] = arr[2][C / 2 + 1] = arr[2][C / 2 + 2] = '*';
        } else {
            int diff = (int)(3 * Math.pow(2, depth - 1));
            for (int i=0; i<diff; i++) {
                for (int j=0; j<C; j++) {
                    if (arr[i][j] != '*') continue;
                    arr[i + diff][j - diff] = arr[i + diff][j + diff] = '*'; 
                }
            }
        }
        getTriangle(depth + 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        br.close();
        
        k = 0;
        int n = N / 3;
        while (n > 1) {
            n /= 2;
            k++;
        }
        
        R = N;
        C = (int)((5 * Math.pow(2, k) + (Math.pow(2, k) - 1)));
        arr = new char[R][C];
        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                arr[i][j] = ' ';
            }
        }
        
        getTriangle(0);
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<R; i++) {
            sb.append(new String(arr[i])).append("\n");
        }
        System.out.println(sb);
    }

}
