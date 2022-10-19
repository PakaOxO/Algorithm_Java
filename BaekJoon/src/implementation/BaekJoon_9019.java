package implementation;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_9019, DSLR
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_9019 {
    static class Node {
        String comb;
        int val;
        
        Node(String comb, int val) {
            this.comb = comb;
            this.val = val;
        }
    }
    
    static int N, M;
    static boolean[] isVisited;
    static StringBuilder sb;
    
    static int operation(int num, char c) {
        int converted = num;
        if (c == 'D') {
            converted = num * 2 % 10000;
        } else if (c == 'S') {
            converted = num >= 1 ? num - 1 : num + 9999;
        } else if (c == 'L') {
            converted = num / 1000;
            converted += num % 1000 * 10;
        } else {
            converted = num % 10 * 1000;
            converted += num / 10;
        }
        return converted;
    }
    
    static int shift(int num) {
        int cnt = 0;
        int n = num;
        for (int i=1; i<=4; i++) {
            n = operation(n, 'L');
            if (n == M) {
                cnt = i;
                break;
            }
        }
        return cnt;
    }
    
    static void bfs(int num) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node("", num));
        
        isVisited = new boolean[10000];
        isVisited[num] = true;
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            
            int sCnt = shift(curr.val);
            if (sCnt > 0) {
                if (sCnt <= 4 - sCnt) {
                    sb.append(curr.comb).append("L".repeat(sCnt));
                } else {
                    sb.append(curr.comb).append("R".repeat(4 - sCnt));
                }
                break;
            }
            
            int next = operation(curr.val, 'D');
            if (!isVisited[next]) {
                if (next == M) {
                    sb.append(curr.comb).append("D");
                    break;
                } else q.offer(new Node(curr.comb + "D", next));
            }
            
            next = operation(curr.val, 'S');
            if (!isVisited[next]) {
                if (next == M) {
                    sb.append(curr.comb).append("S");
                    break;
                } else q.offer(new Node(curr.comb + "S", next));
            }
            
            next = operation(curr.val, 'L');
            if (!isVisited[next]) {
                q.offer(new Node(curr.comb + "L", next));
            }
            
            next = operation(curr.val, 'R');
            if (!isVisited[next]) {
                q.offer(new Node(curr.comb + "R", next));
            }
        }
        
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int tc=1; tc<=T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            sb = new StringBuilder();
            bfs(N);
            answer.append(sb.toString()).append("\n");
        }
        br.close();
        System.out.println(answer);
    }

}

