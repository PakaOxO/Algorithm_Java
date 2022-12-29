package twoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BaekJoon_25916 싫은데요
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_25916 {
    static int N, M, max;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int left = 0;
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (sum + arr[i] <= M) {
                sum += arr[i];
                max = Math.max(sum, max);
            } else {
                while (sum + arr[i] > M) {
                    sum -= arr[left++];
                }
                sum += arr[i];
                max = Math.max(sum, max);
            }
        }
        System.out.println(max);
    }

}
