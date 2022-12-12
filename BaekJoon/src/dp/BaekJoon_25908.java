package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BaekJoon_25908, 수열의 합 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_25908 {
    static int T, S;
    static boolean[] isNotPrime;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        isNotPrime = new boolean[T + 1];
        for (int i=2; i*i<=T; i++) {
            if (isNotPrime[i]) continue;
            
            for (int j=i*i; j<=T; j+=i) {
                isNotPrime[j] = true;
            }
        }
        
        int answer = 0;
        for (int i=S; i<=T; i++) {
            // 소수면 무조건 -2
            if (!isNotPrime[i]) {
                if (i == 2) {
                    answer += 0;
                } else if (i == 1) {
                    answer += -1;
                } else
                    answer += -2;
                
            } else {
                for (int j=1; j*j<=i; j++) {
                    if (i % j == 0) {
                        if (j % 2 == 0) {
                            answer += 1;
                        } else
                            answer -= 1;
                        
                        if (j * j < i) {
                            if ((i / j) % 2 == 0)
                                answer += 1;
                            else
                                answer -= 1;
                        }
                    }
                }
                answer += (i % 2 == 0) ? 1 : -1;
            }
        }
        System.out.println(answer);
    }

}
