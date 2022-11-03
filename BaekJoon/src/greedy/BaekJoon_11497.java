package greedy;

import java.io.*;
import java.util.*;

/**
 * 통나무 건너뛰기 
 * @author kevin-Apre
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_11497 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=T; tc++) {
            int N = Integer.parseInt(br.readLine());
            
            int answer = 0;
            
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            
            for (int i=0; i<N; i++) {
                if (i + 2 < N) answer = Math.max(answer, arr[i + 2] - arr[i]);
            }
            if (N > 1) {
                answer = Math.max(answer, Math.max(arr[1] - arr[0], arr[N-1] - arr[N-2]));
            }
            
            sb.append(answer).append("\n");
        }
        br.close();
        System.out.print(sb);
    }

}
