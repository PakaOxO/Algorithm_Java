package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BaekJoon_25793, 초콜릿 피라미드
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_25793 {
    static long N, M;
    static long cal(long X) {
        return X * (X + 1) * (2 * X + 1) / 3;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int tc=1; tc<=T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            long X = Math.min(N, M);
            long result = cal(X);
            sb.append(result).append(" ").append(result - X).append("\n");
        }
        br.close();
        System.out.print(sb);
    }

}
