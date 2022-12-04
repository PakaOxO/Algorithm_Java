package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BaekJoon_23561, Young한 에너지는 부족하다 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_23561 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N * 3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N*3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        System.out.println(arr[N * 2 - 1] - arr[N]);
    }

}
