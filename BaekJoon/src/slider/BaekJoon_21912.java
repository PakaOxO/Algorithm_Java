package slider;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BaekJoon_21912, 블로그
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_21912 {
    static int N, X, answer;
    static int[] visitors;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int cnt = 0;
        int pointer = 0;
        visitors = new int[N];
        for (int i=0; i<N; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
            if (i < X - 1) {
                sum += visitors[i];
                continue;
            } else if (i == X - 1) {
                sum += visitors[i];
            } else {
                sum += visitors[i] - visitors[pointer++];
            }
            
            if (sum >= answer) {
                if (sum == answer) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                answer = sum;
            }
        }
        
        if (answer == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(answer + "\n" + cnt);
        }
    }

}
