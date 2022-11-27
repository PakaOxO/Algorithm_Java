package combination;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_6603, 로또 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_6603 {
    static int N;
    static int[] arr, sel;
    static StringBuilder sb;
    
    static void comb(int cnt, int depth) {
        if (cnt == 6) {
            for (int i=0; i<6; i++) {
                sb.append(sel[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i=depth; i<N; i++) {
            sel[cnt] = arr[i];
            comb(cnt + 1, i + 1);
        }
    }
    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0) break;
            arr = new int[N];
            sel = new int[6];
            for (int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            comb(0, 0);
            sb.append("\n");
        }
        System.out.println(sb.toString().trim());
    }

}
