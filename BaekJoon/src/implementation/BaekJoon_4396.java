package implementation;

import java.io.*;

/**
 * BaekJoon_4396, 지뢰 찾기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_4396 {
    static int N;
    static char[][] map;
    static int[][] drc = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        char[][] answer = new char[N][N];
        boolean flag = false;
        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<N; j++) {
                char c = line.charAt(j);
                if (c == '.') {
                    answer[i][j] = '.';
                    continue;
                }
                
                if (map[i][j] == '*') {
                    answer[i][j] = '*';
                    flag = true;
                } else {
                    int cnt = 0;
                    for (int k=0; k<8; k++) {
                        int nr = i + drc[k][0];
                        int nc = j + drc[k][1];
                        if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                        if (map[nr][nc] == '*') cnt++;
                    }
                    answer[i][j] = (char)(cnt + '0');
                }
            }
        }
        if (flag) {
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (map[i][j] == '*') answer[i][j] = '*';
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) sb.append(answer[i]).append("\n");
        System.out.println(sb);
    }

}
