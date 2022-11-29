package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BaekJoon_26123, 외계 침략자 윤이
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_26123 {
    static int N, D, max;
    static long answer;
    static int[] cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        cnt = new int[300001];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int height = Integer.parseInt(st.nextToken());
            cnt[height]++;
            max = Math.max(max, height);
        }
        
        answer = 0;
        while (D > 0 && max > 0) {
            answer += cnt[max];
            cnt[max - 1] += cnt[max];
            cnt[max] = 0;
            max--;
            D--;
        }
        System.out.println(answer);
    }

}
