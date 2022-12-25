package array;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_11728, 배열 합치기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_11728 {
    static int N, M;
    static int[] arr1, arr2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr1 = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);
        
        arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr2);
        
        StringBuilder sb = new StringBuilder();
        int p1 = 0, p2 = 0;
        while (true) {
            if (p1 == N && p2 == M) break;
            if (p1 == N) {
                sb.append(arr2[p2++]).append(" ");
                continue;
            }
            if (p2 == M) {
                sb.append(arr1[p1++]).append(" ");
                continue;
            }
            
            if (arr1[p1] <= arr2[p2])
                sb.append(arr1[p1++]).append(" ");
            else
                sb.append(arr2[p2++]).append(" ");
            
        }
        System.out.println(sb.toString().trim());
    }

}
