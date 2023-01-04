package sort;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1253, 좋다, 2포인터로 풀이
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_1253_2 {
    static int N, answer;
    static int[] arr;
    
    static boolean search(int target) {
        int left = 0;
        int right = N - 1;
        while (left < right) {
            if (left == target) {
                left++;
                continue;
            }
            if (right == target) {
                right--;
                continue;
            }
            
            if (arr[left] + arr[right] >= arr[target]) {
                if (arr[left] + arr[right] == arr[target]) return true;
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        for (int i=0; i<N; i++) {
            if (search(i)) answer++;
        }
        System.out.println(answer);
    }

}
