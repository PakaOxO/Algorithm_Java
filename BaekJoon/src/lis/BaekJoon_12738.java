package lis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BaekJoon_12738, 가장 긴 증가하는 부분 수열 3
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_12738 {
    static int N, numberSize;
    static int[] arr;
    static int[] number;
    
    static int binarySearch(int target, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (target >= number[mid]) {
                if (target == number[mid]) return mid;
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        number = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        for (int i=0; i<N; i++) {
            if (numberSize == 0) {
                number[numberSize++] = arr[i];
                continue;
            } else if (arr[i] > number[numberSize - 1]) {
                number[numberSize++] = arr[i];
                continue;
            }
            
            int idx = binarySearch(arr[i], 0, numberSize);
            number[idx] = arr[i];
        }
        
        System.out.println(numberSize);
    }

}
