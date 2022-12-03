package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BaekJoon_25487, 단순한 문제 (Large) 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_25487 {
    static int a, b, c, cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int tc=0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            
            cnt = 0;
            for (int i=1; i<=a; i++) {
                for (int j=1; j<=b; j++) {
                    for (int k=1; k<=c; k++) {
                        if (i % j != j % k) continue;
                        if (j % k != k % i) continue;
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

}
