package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * BaekJoon_20311, 화학 실험 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_20311 {
    static int N, K;
    static int[][] c;
    static int[] sel;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        c = new int[K][2];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<K; i++) {
            c[i][0] = i + 1;
            c[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(c, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        
        sel = new int[N];
        int cnt = N, idx = 0, pos = 0;
        while (true) {
            sel[pos] = c[idx][0];
            c[idx][1]--;
            pos += 2;
            cnt--;
            
            if (cnt == 0) break;
            if (c[idx][1] == 0) idx++;
            if (idx == K) break;
            if (pos >= N) {
                if (pos % 2 == 0) {
                    if (sel[0] == c[idx][0]) break;
                    pos = 1;
                }
                else break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        if (cnt == 0) {
            for (int i=0; i<N; i++) {
                if (i < N - 1) sb.append(sel[i]).append(" ");
                else sb.append(sel[i]);
            }
        } else
            sb.append(-1);
        
        System.out.println(sb);
    }

}
