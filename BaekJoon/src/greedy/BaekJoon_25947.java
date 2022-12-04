package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BaekJoon_25947, 선물할인 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 먼저 입력받은 선물의 가격을 정렬 
 *
 */
public class BaekJoon_25947 {
    static int N, b, a, answer;
    static int[] price, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        
        price = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(price);
        
        dp = new int[N + 1];
        for (int i=1; i<=N; i++) {
            if (i <= a) {
                dp[i] = dp[i - 1] + (price[i] / 2);
            } else {
                dp[i] = dp[i - 1] + (price[i] / 2) + (price[i - a] / 2);
            }
            if (dp[i] > b) break;
            answer = i;
        }
        System.out.println(answer);
    }

}
