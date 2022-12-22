package shortestPath;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_4485, 녹색 옷을 입은 애가 젤다지? 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_4485 {
    static int N, answer;
    static int[][] map;
    static int[][] drc = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    
    static class Node implements Comparable<Node> {
        int r, c, w;
        
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
        Node(int r, int c, int w) {
            this.r = r;
            this.c = c;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
    
    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, map[0][0]));
        
        boolean[][] isVisited = new boolean[N][N];
        isVisited[0][0] = true;
        
        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            
            for (int i=0; i<4; i++) {
                int nr = curr.r + drc[i][0];
                int nc = curr.c + drc[i][1];
                
                if (nr < 0 || nc < 0 || nr >= N || nc >= N || isVisited[nr][nc]) continue;
                isVisited[nr][nc] = true;
                if (nr == N - 1 && nc == N - 1) {
                    answer = curr.w + map[nr][nc];
                    return;
                }
                pq.offer(new Node(nr, nc, curr.w + map[nr][nc]));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int no = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            
            map = new int[N][N];
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            answer = 0;
            dijkstra();
            sb.append("Problem ").append(no).append(": ").append(answer).append("\n");
            no++;
        }
        System.out.println(sb.toString().trim());
    }

}
