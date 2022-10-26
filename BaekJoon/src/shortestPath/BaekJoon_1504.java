package shortestPath;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1504, 특정한 최단 경로
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 특정 두 정점을 지나야 하면서 1에서 출발해 N 정점으로 이동해야함
 *  2. 지나야하는 두 정점을 가는 와중에 N 정점을 도착했더라도 문제 조건에 의해 이전 방문 간선, 정점을 재 방문 가능하므로 무시
 *  3. 다익스트라를 사용하되 거쳐야 하는 두 정점의 순서를 바꾼 총 2가지 경로 중 최단 거리를 정답으로 출력
 *
 */
public class BaekJoon_1504 {
    static class Node implements Comparable<Node> {
        int e, w;
        Node next;
        
        Node(int e, int w) {
            this.e = e;
            this.w = w;
        }
        
        Node(int e, int w, Node next) {
            this.e = e;
            this.w = w;
            this.next = next;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
    
    static final int INF = Integer.MAX_VALUE >> 2;
    static int V, E;
    static Node[] adjList;
    
    static int n1, n2;
    
    static int dijkstra(int s, int e) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s, 0));
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[s] = 0;
        boolean[] isVisited = new boolean[V + 1];
        
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (isVisited[curr.e]) continue; 
            isVisited[curr.e] = true; 
            
            for (Node next=adjList[curr.e]; next!=null; next=next.next) {
                if (isVisited[next.e] || dist[next.e] <= dist[curr.e] + next.w) continue;
                dist[next.e] = dist[curr.e] + next.w;
                
                pq.offer(new Node(next.e, dist[next.e]));
            }
        }
        return dist[e];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        adjList = new Node[V + 1];
        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            adjList[s] = new Node(e, w, adjList[s]);
            adjList[e] = new Node(s, w, adjList[e]);
        }
        
        st = new StringTokenizer(br.readLine());
        n1 = Integer.parseInt(st.nextToken());
        n2 = Integer.parseInt(st.nextToken());
        br.close();
        
        int toN1 = dijkstra(1, n1);
        int toN2 = dijkstra(1, n2);
        int btwN1N2 = dijkstra(n1, n2);
        int toEnd1 = dijkstra(n1, V);
        int toEnd2 = dijkstra(n2, V);
        
        
        int answer = INF;
        
        if (toN1 != INF && btwN1N2 != INF && toEnd2 != INF) {
            answer = Math.min(answer, toN1 + btwN1N2 + toEnd2);
        }
        if (toN2 != INF && btwN1N2 != INF && toEnd1 != INF) {
            answer = Math.min(answer, toN2 + btwN1N2 + toEnd1);
        }

        if (answer == INF) answer = -1;
        System.out.println(answer);
    }

}
