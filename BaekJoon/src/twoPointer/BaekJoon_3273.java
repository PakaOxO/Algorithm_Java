package twoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BaekJoon_3273, 두 수의 합
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_3273 {
    static int N, x, answer;
    static int[] arr;
    static boolean[] hasNum = new boolean[1000001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(br.readLine());
        
        arr = new int[N];
        for (int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (i > 0 && x > num && hasNum[x - num]) answer++;
            hasNum[num] = true;
        }
        
        System.out.println(answer);
    }

}
