package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BaekJoon_1026, 보물
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_1026 {
    static int[] arrA, arrB;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        arrA = new int[N];
        arrB = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arrA[i] = Integer.parseInt(st1.nextToken());
            arrB[i] = Integer.parseInt(st2.nextToken());
        }
        
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        int answer = 0;
        for (int i=0; i<N; i++) {
            answer += arrA[i] * arrB[N - i - 1];
        }
        System.out.println(answer);
    }

}
