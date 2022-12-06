package adhoc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BaekJoon_4307, 개미 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_4307 {
    static int D, N;
    static int[] pos;
    
    static int getMin() {
        int diff = D;
        int mid = 0;
        for (int i=0; i<N; i++) {
            if (Math.abs(pos[i] - (D / 2)) < diff) {
                mid = pos[i];
                diff = Math.abs(pos[i] - (D / 2));
            }
        }
        return Math.min(mid, D - mid);
    }
    
    static int getMax() {
        int max = 0;
        for (int i=0; i<N; i++) {
            max = Math.max(max, Math.max(D - pos[i], pos[i]));
        }
        
        return max;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int tc=0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            
            pos = new int[N];
            for (int j=0; j<N; j++) {
                pos[j] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(pos);
            
            sb.append(getMin()).append(" ").append(getMax()).append("\n");
        }
        
        System.out.println(sb.toString().trim());
    }

}
