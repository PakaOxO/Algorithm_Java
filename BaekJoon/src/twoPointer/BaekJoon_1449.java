package twoPointer;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1449, 수리공 항승 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_1449 {
    static int N, L, cnt;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        
        int end = -1;
        for (int i=0; i<N; i++) {
            if (arr[i] <= end) continue;
            end = arr[i] + L - 1;
            cnt++;
        }
        System.out.println(cnt);
    }

}
