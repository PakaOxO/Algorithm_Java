package divideAndConquer;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_10830, 행렬 제곱
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_10830 {
    static int N;
    static long B;
    static long[][] arr;
    
    static long cal(int r, int c, long[][] arr1, long[][] arr2) {
        long val = 0;
        for (int i=0; i<N; i++) {
            val = (val + ((arr1[r][i] * arr2[i][c]) % 1000)) % 1000;
        }
        return val;
    }
    
    static long[][] square(long[][] arr1, long[][] arr2) {
        long[][] returnArr = new long[N][N];
        
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                returnArr[i][j] = cal(i, j, arr1, arr2);
            }
        }
        return returnArr;
    }
    
    static long[][] getAnswer(long b) {
        if (b == 1) {
            long[][] returnArr = new long[N][N];
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    returnArr[i][j] = arr[i][j] % 1000;
                }
            }
            return returnArr;
        }
        
        long[][] halfArr = getAnswer(b / 2);
        if (b % 2 == 0) {
            return square(halfArr, halfArr); 
        } else {
            return square(square(halfArr, halfArr), arr);
        }
        
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        
        arr = new long[N][N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }
        br.close();
        
        long[][] answer = getAnswer(B);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

}
