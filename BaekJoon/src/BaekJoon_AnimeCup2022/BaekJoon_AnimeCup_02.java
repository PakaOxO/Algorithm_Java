package BaekJoon_AnimeCup2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BaekJoon_AnimeCup_02, 치노의 라떼 아트(Easy) - 포기.... 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_AnimeCup_02 {
    static int R, C;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int tc=0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new char[R][C];
            
            int cnt = 0;
            for (int i=0; i<R; i++) {
                String line = br.readLine();
                for (int j=0; j<C; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == '#') cnt++;
                }
            }
        }
    }

}
