package recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BaekJoon_1992, 쿼드트리 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_1992 {
    static int N;
    static char[][] map;
    
    static boolean check(int top, int left, int len) {
        char prev = '0';
        for (int i=top; i<top+len; i++) {
            for (int j=left; j<left+len; j++) {
                if (i == top && j == left) {
                    prev = map[top][left];
                    continue;
                }
                if (map[i][j] != prev) return false;
            }
        }
        return true;
    }
    
    static String compress(int top, int left, int len) {
        if (len == 1) return String.valueOf(map[top][left]);
        StringBuilder sb = new StringBuilder();
        
        if (check(top, left, len)) {
            sb.append(String.valueOf(map[top][left]));
        } else {
            sb.append("(");
            
            sb.append(compress(top, left, len / 2));
            sb.append(compress(top, left + (len / 2), len / 2));
            sb.append(compress(top + (len / 2), left, len / 2));
            sb.append(compress(top + (len / 2), left + (len / 2), len / 2));
            
            sb.append(")");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        String answer = compress(0, 0, N);
        System.out.println(answer);
    }

}
