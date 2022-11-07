package shortestPath;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_11779, 최소비용 구하기 2
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_11779 {
    static class Node implements Comparable<Node> {
        int e, w;
        Node next;
        Node prev;
        
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
            return this.w <= o.w ? -1 : 1;
        }
    }
    
    static final int INF = Integer.MAX_VALUE >> 1;
    static int N, M;
    static Node[] adjList;
    static int[] dist;
    static Node last;
    
    static void dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        boolean[] isVisited = new boolean[N + 1];
        
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (isVisited[curr.e]) continue;
            isVisited[curr.e] = true;

            for (Node next=adjList[curr.e]; next!=null; next=next.next) {
                if (isVisited[next.e] || dist[next.e] <= dist[curr.e] + next.w) continue;
                dist[next.e] = dist[curr.e] + next.w;
                
                Node n = new Node(next.e, dist[next.e]);
                n.prev = curr;
                if (n.e == end) last = n;
                pq.offer(n);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        adjList = new Node[N + 1];
        for (int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            adjList[s] = new Node(e, w, adjList[s]);
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start, end);
        
        List<Integer> path = new ArrayList<>();
        Node prev = last;
        while (prev != null) {
            path.add(prev.e);
            prev = prev.prev;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(last.w).append("\n").append(path.size()).append("\n");
        for (int i=path.size()-1; i>=0; i--) {
            if (i > 0) sb.append(path.get(i)).append(" ");
            else sb.append(path.get(i));
        }
        System.out.println(sb);
    }

}
