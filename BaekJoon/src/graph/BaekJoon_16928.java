package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_16928, 뱀과 사다리 게임
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 1부터 100까지 dist 배열을 만들어 현재 위치에서 이동할 수 있는 위치에 현재 위치 거리 + 1와 해당 위치 값 중 최소값으로 갱신
 *  2. 만약 이동할 수 있는 거리에 사다리나 뱀이 있다면 타고 이동한 자리의 dist값을 갱신
 *  3. 탐색은 시행횟수(주사위를 던진 횟수)가 적은 페이즈부터 탐색하기 위해 BFS 사용
 *
 */
public class BaekJoon_16928 {
    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static int[] dist, map;
    
    static void play() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        dist[1] = 0;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            for (int i=1; i<=6; i++) {
                int next = curr + i;
                if (next > 100 || dist[next] <= dist[curr]) continue;
                
                if (map[next] > 0) {
                    next = map[next];
                }
                if (dist[next] <= dist[curr]) continue;
                
                dist[next] = dist[curr] + 1;
                if (next == 100) return;
                q.offer(next);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        dist = new int[101];
        map = new int[101];
        
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        br.close();
        
        Arrays.fill(dist, INF);
        play();
        System.out.println(dist[100]);
    }

}
