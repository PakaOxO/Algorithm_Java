package bruteForce;

import java.io.*;

/**
 * BaekJoon_17359, 전구 길만 걷자 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_17359 {
    static int N, cnt, answer;
    static int[][] joint;
    static int[] comb;
    static boolean[] isVisited;
    
    static void dfs(int depth) {
        if (depth == N) {
            int prev = joint[comb[0]][1];
            int c = 0;
            for (int i=1; i<N; i++) {
                if (prev != joint[comb[i]][0]) c++;
                if (cnt + c >= answer) return;
                prev = joint[comb[i]][1];
            }
            answer = Math.min(answer, cnt + c);
            return;
        }
        
        for (int i=0; i<N; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            comb[depth] = i;
            dfs(depth + 1);
            isVisited[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        joint = new int[N][2];
        for (int i=0; i<N; i++) {
            String str = br.readLine();
            char prev = str.charAt(0);
            for (int j=0; j<str.length(); j++) {
                if (j == 0) {
                    joint[i][0] = (int)(str.charAt(j) - '0');
                }
                if (j == str.length() - 1) {
                    joint[i][1] = (int)(str.charAt(j) - '0');
                }
                if (str.charAt(j) != prev) cnt++;
                prev = str.charAt(j);
            }
        }
        comb = new int[N];
        isVisited = new boolean[N];
        answer = Integer.MAX_VALUE;
        dfs(0);
        System.out.println(answer);
    }

}
