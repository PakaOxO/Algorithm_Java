package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BaekJoon_2239, 스도쿠
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_2239 {
    static char[][] board;
    static boolean[][] checkR = new boolean[9][10];
    static boolean[][] checkC = new boolean[9][10];
    static boolean[][] checkB = new boolean[9][10];
    static StringBuilder sb;
    
    static int blockIdx(int r, int c) {
        return (r / 3 * 3) + (c / 3);
    }
    
    static void dfs(int r, int c) {
        if (c > 8) {
            c = 0;
            r++;
        }
        if (r > 8) {
            for (int i=0; i<9; i++) {
                sb.append(new String(board[i])).append("\n");
            }
            System.out.println(sb);
            System.exit(0);
            return;
        }
        
        if (board[r][c] != '0') dfs(r, c + 1);
        else {
            for (int i=1; i<=9; i++) {
                if (checkR[r][i] || checkC[c][i] || checkB[blockIdx(r, c)][i]) continue;
                board[r][c] = (char)(i + '0');
                checkR[r][i] = true;
                checkC[c][i] = true;
                checkB[blockIdx(r, c)][i] = true;
                
                dfs(r, c + 1);
                
                board[r][c] = '0';
                checkR[r][i] = false;
                checkC[c][i] = false;
                checkB[blockIdx(r, c)][i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        board = new char[9][9];
        for (int i=0; i<9; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j=0; j<9; j++) {
                if (board[i][j] == '0') continue;
                
                checkR[i][(int)(board[i][j] - '0')] = true;
                checkC[j][(int)(board[i][j] - '0')] = true;
                checkB[blockIdx(i, j)][(int)(board[i][j] - '0')] = true;
            }
        }
        br.close();
        
        sb = new StringBuilder();
        dfs(0, 0);
        System.out.print(sb);
    }

}
