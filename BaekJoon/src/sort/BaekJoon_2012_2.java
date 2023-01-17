package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BaekJoon_2012_2, 정렬 사용하지 않고 풀
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_2012_2 {
    static int N;
    static int[] cnt = new int[500001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        for (int i=0; i<N; i++) ++cnt[Integer.parseInt(br.readLine())];
        int rank = 1;
        long answer = 0;
        int n = 0;
        loop:
        for (int i=1; i<=500000; i++) {
            if (cnt[i] == 0) continue;
            while (cnt[i] > 0) {
                answer += Math.abs(rank - i);
                rank++;
                cnt[i]--;
                n++;
                if (n == N) break loop;
            }
        }
        System.out.println(answer);
    }

}
