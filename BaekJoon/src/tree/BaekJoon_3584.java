package tree;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_3584, 가장 가까운 공통 조상
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_3584 {
    static class Node {
        Node parent;
        int id;
        
        Node(int id) {
            this.id = id;
        }
    }
    
    static int N;
    static Node[] nodes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int tc=0; tc<T; tc++) {
            N = Integer.parseInt(br.readLine());
            nodes = new Node[N + 1];
            for (int i=0; i<N-1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                if (nodes[A] == null) nodes[A] = new Node(A);
                if (nodes[B] == null) nodes[B] = new Node(B);
                nodes[B].parent = nodes[A];
            }
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean[] check = new boolean[N + 1];
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            Node n1 = nodes[A];
            Node n2 = nodes[B];
            check[n1.id] = true;
            check[n2.id] = true;
            while (true) {
                n1 = (n1 != null) ? n1.parent : n1;
                n2 = (n2 != null) ? n2.parent : n2;
                if (n1 != null) {
                    if (check[n1.id]) {
                        sb.append(n1.id).append("\n");
                        break;
                    }
                    check[n1.id] = true;
                }
                if (n2 != null) {
                    if (check[n2.id]) {
                        sb.append(n2.id).append("\n");
                        break;
                    }
                    check[n2.id] = true;
                }
            }
        }
        System.out.println(sb);
    }

}
