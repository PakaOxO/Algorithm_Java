package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * BaekJoon_1256, 사전
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_1256 {
    static int N, M, K;
    static int INF = 1000000000;
    
    static double comb(int N, int M) {
        if (N == 0 || M == 0) return 1;
        BigInteger result = new BigInteger("1");
        
        if (N >= M) {
            for (int i=(N + M); i>N; i--) {
                result = result.multiply(new BigInteger(String.valueOf(i)));
            }
            for (int i=1; i<=M; i++) {
                result = result.divide(new BigInteger(String.valueOf(i)));
            }
        } else {
            for (int i=(N + M); i>M; i--) {
                result = result.multiply(new BigInteger(String.valueOf(i)));
            }
            for (int i=1; i<=N; i++) {
                result = result.divide(new BigInteger(String.valueOf(i)));
            }
        }
        return result.doubleValue();
    }
    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        
        double c = comb(N, M);
        if (c < K) {
            sb.append(-1);
        } else {
            int cnt = N + M;
            
            double left = 1;
            double right = c + 1;
            System.out.println(c);
            
            for (int i=0; i<cnt; i++) {
                double mid = Math.floor(left + ((right - left) * ((double)N / (N + M)) - 1));
                System.out.println(mid);
                if (K <= mid) {
                    sb.append('a');
                    N--;
                    right = mid + 1;
                } else {
                    sb.append('z');
                    M--;
                    left = mid + 1;
                }
            }
        }
        System.out.println(sb);
    }

}
