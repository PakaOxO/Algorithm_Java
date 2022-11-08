package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_12852, 1로 만들기 2
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */

public class BaekJoon_12852 {
    static class Node {
        int val;
        Node prev;

        Node(int val, Node prev) {
            this.val = val;
            this.prev = prev;
        }
    }

    static int N;
    static Node last;

    static void bfs() {
        if (N == 1)
            return;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(N, null));

        boolean[] isVisited = new boolean[1000001];
        isVisited[N] = true;

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.val % 3 == 0 && !isVisited[curr.val / 3] && curr.val / 3 > 0) {
                Node next = new Node(curr.val / 3, curr);
                if (next.val == 1) {
                    last = next;
                    return;
                }
                q.offer(next);
            }
            if (curr.val % 2 == 0 && !isVisited[curr.val / 3] && curr.val / 2 > 0) {
                Node next = new Node(curr.val / 2, curr);
                if (next.val == 1) {
                    last = next;
                    return;
                }
                q.offer(next);
            }

            if (curr.val > 1 && !isVisited[curr.val - 1]) {
                Node next = new Node(curr.val - 1, curr);
                if (next.val == 1) {
                    last = next;
                    return;
                }
                q.offer(next);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        br.close();
        bfs();

        StringBuilder sb = new StringBuilder();
        if (last != null) {
            List<Integer> path = new ArrayList<>();
            Node prev = last;
            while (prev != null) {
                path.add(prev.val);
                prev = prev.prev;
            }
            sb.append(path.size() - 1).append("\n");
            for (int i = path.size() - 1; i >= 0; i--) {
                if (i > 0)
                    sb.append(path.get(i)).append(" ");
                else
                    sb.append(path.get(i));
            }
        } else {
            sb.append("0\n1");
        }

        System.out.println(sb);
    }

}
