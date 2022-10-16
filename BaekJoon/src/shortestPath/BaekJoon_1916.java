package shortestPath;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1916, 최소비용 구하기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 정점 A에서 B로 가는 최단 거리를 구하는 문제
 *  2. 다익스트라 사용
 *
 */
public class BaekJoon_1916 {
    static class Node implements Comparable<Node> {
        int v;
        long w;
        Node next;
        
        Node(int v, long w) {
            this.v = v;
            this.w = w;
        }
        
        Node(int v, long w, Node next) {
            this.v = v;
            this.w = w;
            this.next = next;
        }

        @Override
        public int compareTo(Node o) {
            return this.w < o.w ? -1 : 1;
        }
    }
    
    static final int INF = Integer.MAX_VALUE;
    static int V, E, start, end;
    static long answer;
    static int[][] adjArr;
    
    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        
        long[] dist = new long[V];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        boolean[] isVisited = new boolean[V];
        int cnt = 0;
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (isVisited[curr.v]) continue;
            isVisited[curr.v] = true;
            
            if (++cnt == V) break;
            
            for (int i=0; i<V; i++) {
                if (i == curr.v || adjArr[curr.v][i] == INF || isVisited[i] || dist[i] <= dist[curr.v] + adjArr[curr.v][i]) continue;
                dist[i] = dist[curr.v] + adjArr[curr.v][i];
                pq.offer(new Node(i, dist[i]));
            }
        }
        answer = dist[end];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        adjArr = new int[V][V];
        for (int[] arr : adjArr) Arrays.fill(arr, INF);
        
        for (int i=0; i<E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            
            adjArr[s][e] = Math.min(adjArr[s][e], w);
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken()) - 1;
        end = Integer.parseInt(st.nextToken()) - 1;
        br.close();
        
        dijkstra();
        System.out.println(answer);
    }

}
