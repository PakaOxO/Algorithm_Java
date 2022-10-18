package implementation;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2828, 사과 담기 게임
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_2828 {
    static int N, M, answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int J = Integer.parseInt(br.readLine());
        int left = 1;
        int right = M;
        for (int i=0; i<J; i++) {
            int apple = Integer.parseInt(br.readLine());
            if (apple >= left && apple <= right) {
                continue;
            } else if (left > apple) {
                int diff = left - apple;
                left -= diff;
                right -= diff;
                answer += diff;
            } else if (apple > right) {
                int diff = apple - right;
                left += diff;
                right += diff;
                answer += diff;
            }
        }
        br.close();
        System.out.println(answer);
    }

}
