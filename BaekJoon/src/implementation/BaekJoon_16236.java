package implementation;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_16236, 아기 상어
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 처음 위치에서 시작하는 BFS 탐색
 *      1.1 한번의 BFS 탐색에서는 1마리의 물고기를 먹으면 stop
 *      1.2 BFS 탐색에서는 현재 위치 기준 사방 탐색을 하면서 가깝고->위에있고->왼쪽에 있는 순으로 우선 탐색(우선순위큐 사용)
 *      1.3 물고기는 자신보다 작은 물고기만 먹고, 큰 물고기가 있는 위치로는 이동 불가
 *      1.4 물고기를 먹으면 크기가 커질때까지 필요한 물고기 카운트(cnt)를 줄이고 만약 cnt가 0이되면 상어 크기를 1증가, cnt는 상어 크기만큼 초기화
 *      1.5 시간은 이동한 시간만큼 time에 추가
 *  2. BFS 탐색에서 먹은 물고기가 없으면 return false, 리턴값이 false이면 더 이상 먹을 수 있는 물고기가 없으므로 time을 출력하고 프로그램 종료
 *
 */
public class BaekJoon_16236 {
    static class Shark {
        int size, r, c, cnt;
    }
    
    static int N, time;
    static int[][] map;
    static boolean[][] isVisited;
    static int[][] drc = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
    static Shark s = new Shark();
    
    static boolean bfs(int sR, int sC) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[2] == o2[2]) {
                    if (o1[0] == o2[0]) return o1[1] - o2[1];
                    else return o1[0] - o2[0];
                }
                return o1[2] - o2[2];
            }
        });
        pq.offer(new int[] { sR, sC, 0 });
        
        isVisited = new boolean[N][N];
        isVisited[sR][sC] = true;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            
            int val = map[curr[0]][curr[1]];
            if (val != 0 && val < s.size) { 
                s.r = curr[0];
                s.c = curr[1];
                s.cnt++;
                time += curr[2];
                map[curr[0]][curr[1]] = 0;
                return true;
            }
            
            for (int i=0; i<4; i++) {
                int nr = curr[0] + drc[i][0];
                int nc = curr[1] + drc[i][1];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N || isVisited[nr][nc]) continue;
                if (map[nr][nc] > s.size) continue;
                
                pq.offer(new int[] { nr, nc, curr[2] + 1 });
                isVisited[nr][nc] = true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    s.r = i;
                    s.c = j;
                }
            }
        }
        br.close();
        
        s.size = 2;
        s.cnt = 0;
        map[s.r][s.c] = 0; 
        while (true) {
            boolean flag = bfs(s.r, s.c);
            if (!flag) break;
            if (s.cnt == s.size) {
                s.size++;
                s.cnt = 0;
            }
        }
        
        System.out.println(time);
    }

}
