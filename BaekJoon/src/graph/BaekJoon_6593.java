package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_6593, 상범 빌딩
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_6593 {
    static class Pos {
        int l, r, c, depth;
        
        Pos() {
            this.l = 0;
            this.r = 0;
            this.c = 0;
        }
        
        Pos(int l, int r, int c, int depth) {
            this.l = l;
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }
    
    static int L, R, C, answer;
    static Pos start = new Pos();
    static char[][][] map;
    static boolean[][][] isVisited;
    static int[][] drc = { { -1, 0, 0 }, { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 }, { 0, -1, 0 }, { 0, 0, -1 } };
    
    static int findPath(int sL, int sR, int sC) {
        Queue<Pos> q = new LinkedList<>();
        
        isVisited = new boolean[L][R][C];
        isVisited[sL][sR][sC] = true;
        q.offer(new Pos(sL, sR, sC, 0));
        
        while (!q.isEmpty()) {
            Pos curr = q.poll();
            
            for (int i=0; i<6; i++) {
                int nl = curr.l + drc[i][0];
                int nr = curr.r + drc[i][1];
                int nc = curr.c + drc[i][2];
                if (( nl < 0 || nl >= L ) || ( nr < 0 || nr >= R ) || ( nc < 0 || nc >= C ) || map[nl][nr][nc] == '#' || isVisited[nl][nr][nc]) continue;
                
                if (map[nl][nr][nc] == 'E') return curr.depth + 1;
                
                q.offer(new Pos(nl, nr, nc, curr.depth + 1));
                isVisited[nl][nr][nc] = true;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (L == R && R == C && C == 0) break;
            
            map = new char[L][R][C];
            for (int i=0; i<L; i++) {
                for (int j=0; j<R; j++) {
                    String line = br.readLine();
                    for (int k=0; k<C; k++) {
                        map[i][j][k] = line.charAt(k);
                        if (map[i][j][k] == 'S') {
                            start.l = i;
                            start.r = j;
                            start.c = k;
                            start.depth = 0;
                        }
                    }
                }
                br.readLine();
            }
            
            answer = findPath(start.l, start.r, start.c);
            if (answer > 0) {
                sb.append("Escaped in ").append(answer).append(" minute(s).\n");
            } else {
                sb.append("Trapped!\n");
            }
        }
        System.out.println(sb.toString().trim());
    }

}
