package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1941, 소문난 칠공주
 * @author kevin-Arpe
 *
 * Sketch Idea
 *  1. 전체 25개 중 7개를 선택하는 건 시간초과... 약 20만개가 넘는듯
 *  2. 선택할 7개 중에서 다솜파는 4명 이상, 도연파는 3명이하로 구성되어야 함
 *      2.1 입력받은 25명 정보를 다솜파와 도연파로 구분한 뒤 각각에서 4명-3명, 5명-2명, 6명-1명, 7명-0명 뽑는 경우로 구분
 *      2.2 이렇게 하니 조합의 가지수가 줄어들어 시간초과 해결
 *      2.3 이제 인원 밸런스는 뽑으면서 맞췄으므로 다 뽑았을 때 서로 붙어있는 자리인지 BFS로 체크하면 됨
 *      
 *  3. 지우님 코드를 보니 시간 효율성이 매우 좋음. 비트마스킹-조합으로 푸신 듯 나중에 체크
 *  
 */
public class BaekJoon_1941 {
    static char[][] map;
    static int[] sel;
    static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    static boolean[] isVisited;
    static List<Integer> sPos;
    static List<Integer> yPos;
    static int answer;
    
    static boolean check(int sR, int sC) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { sR, sC });
        boolean[][] v = new boolean[5][5];
        v[sR][sC] = true;
        
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            
            for (int i=0; i<4; i++) {
                int nr = r + drc[i][0];
                int nc = c + drc[i][1];
                if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || v[nr][nc] || !isVisited[nr * 5 + nc]) continue;
                v[nr][nc] = true;
                cnt++;
                q.offer(new int[] { nr, nc });
            }
        }
        if (cnt == 7) return true;
        else return false;
    }
    
    static void selDoyeon(int start, int depth, int max) {
        if (depth == max) {
            if (check(sel[0] / 5, sel[0] % 5)) answer++;
            return;
        }
        
        for (int i=start; i<yPos.size(); i++) {
            isVisited[yPos.get(i)] = true;
            sel[depth] = yPos.get(i);
            selDoyeon(i + 1, depth + 1, max);
            isVisited[yPos.get(i)] = false;
        }
    }
    
    static void selDasom(int start, int depth, int max) {
        if (depth == max) {
            selDoyeon(0, max, 7);
            return;
        }
        
        for (int i=start; i<sPos.size(); i++) {
            isVisited[sPos.get(i)] = true;
            sel[depth] = sPos.get(i);
            selDasom(i + 1, depth + 1, max);
            isVisited[sPos.get(i)] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        map = new char[5][5];
        sPos = new ArrayList<>();
        yPos = new ArrayList<>();
        for (int i=0; i<5; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j=0; j<5; j++) {
                if (map[i][j] == 'S') sPos.add(i * 5 + j);
                else yPos.add(i * 5 + j);
            }
        }
        br.close();
        
        sel = new int[7];
        isVisited = new boolean[25];
        for (int i=4; i<=7; i++) {
            if (i > sPos.size()) break;
            selDasom(0, 0, i);
        }
        
        System.out.println(answer);
    }

}
