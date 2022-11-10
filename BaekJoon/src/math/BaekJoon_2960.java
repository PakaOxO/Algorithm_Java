package math;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2960, 에라토스테네스의 체
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_2960 {
    static int N, K;
    static boolean[] isRemoved;
    static boolean[] isNotPrime;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        br.close();
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        isRemoved = new boolean[N + 1];
        isNotPrime = new boolean[N + 1];
        
        for (int i=2; i*i<=N; i++) {
            if (isNotPrime[i]) continue;
            for (int j=i*i; j<=N; j+=i) {
                isNotPrime[j] = true;
            }
        }
        
        int cnt = 0;
        int answer = -1;
        loop:
        while (true) {
            for (int i=2; i<=N; i++) {
                if (isRemoved[i]) continue;
                for (int j=i; j<=N; j+=i) {
                    if (isRemoved[j]) continue;
                    isRemoved[j] = true;
                    cnt++;
                    if (cnt == K) {
                        answer = j;
                        break loop;
                    }
                }
            }
        }
        System.out.println(answer);
    }

}
