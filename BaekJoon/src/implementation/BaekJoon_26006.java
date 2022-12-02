package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BaekJoon_26006, K-Queen
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_26006 {
    static int N, K;
    static int[] king;
    static int[][] queens;
    static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };
    
    static boolean checkBefore() {
        for (int i=0; i<K; i++) {
            // 가로, 세로
            if (queens[i][0] == king[0] || queens[i][1] == king[1]) return true;
            
            // '/' 방향 대각선
            if (queens[i][0] + queens[i][1] == king[0] + king[1]) return true;
            
            // '\' 방향 대각선
            if (queens[i][0] - king[0] == queens[i][1] - king[1]) return true;
        }
        
        return false;
    }
    
    static boolean checkAfter() {
        for (int i=0; i<8; i++) {
            int nr = king[0] + drc[i][0];
            int nc = king[1] + drc[i][1];
            if (nr < 1 || nc < 1 || nr > N || nc > N) continue;
            boolean flag = false;
            for (int j=0; j<K; j++) {
                // 가로, 세로
                if (queens[j][0] == nr || queens[j][1] == nc) {
                    flag = true;
                    break;
                }
                
                // '/' 방향 대각선
                if (queens[j][0] + queens[j][1] == nr + nc) {
                    flag = true;
                    break;
                }
                
                // '\' 방향 대각선
                if (queens[j][0] - nr == queens[j][1] - nc) {
                    flag = true;
                    break;
                }
            }
            
            if (!flag) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        king = new int[2];
        st = new StringTokenizer(br.readLine());
        king[0] = Integer.parseInt(st.nextToken());
        king[1] = Integer.parseInt(st.nextToken());
        
        queens = new int[K][2];
        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            queens[i][0] = Integer.parseInt(st.nextToken());
            queens[i][1] = Integer.parseInt(st.nextToken());
        }
        
        boolean before = checkBefore();
        boolean after = checkAfter();
        
        if (after && before) {
            System.out.println("CHECKMATE");
        } else if (before) {
            System.out.println("CHECK");
        } else if (after) {
            System.out.println("STALEMATE");
        } else {
            System.out.println("NONE");
        }
    }

}
