package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BaekJoon_12842, 튀김 소보루 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_12842 {
    static int N, S, M, answer;
    static int[] time;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        M = Integer.parseInt(br.readLine());
        
        time = new int[M + 1];
        
        for (int i=1; i<=M; i++) {
            time[i] = Integer.parseInt(br.readLine());
        }
        
        int res = N;
        loop:
        for (int i=0; true; i++) {
            if (i == 0) {
                if (res - S <= M) {
                    answer = res - S;
                    break;
                }
                res -= M;
            }
            
            for (int j=1; j<=M; j++) {
                if (time[j] <= i && i % time[j] == 0) {
                    res--;
                    if (res == S) {
                        answer = j;
                        break loop;
                    }
                }
            }
        }
        System.out.println(answer);
    }

}
