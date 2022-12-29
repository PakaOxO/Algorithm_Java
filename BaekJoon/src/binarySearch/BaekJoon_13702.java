package binarySearch;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_13702, 이상한 술집 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_13702 {
    static int N, K, max;
    static int[] arr;
    
    static boolean check(long w) {
        if (w == 0) return true;
        long cnt = 0;
        for (int i=0; i<N; i++) {
            cnt += arr[i] / w;
            if (cnt >= K) return true;
        }
        return false;
    }
    
    static int binarySearch() {
        int left = 0;
        int right = max;
        
        while (left <= right) {
            int mid = (int)(((long)left + right) / 2);
            if (check(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > max) max = arr[i];
        }
        
        System.out.println(binarySearch());
    }

}
