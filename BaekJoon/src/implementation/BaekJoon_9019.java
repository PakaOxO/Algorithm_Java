package implementation;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_9019, DSLR
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 현재 숫자에서 할 수 있는 연산은 4가지
 *  2. 가장 적은 연산으로 M을 만들어야 하므로 처음 N에서 시작해 4가지 연산을 진행하며 BFS 탐색
 *  3. 큐에 담는 노드에는 누적연산의 결과(문자열), 그리고 연산으로 새로 받은 숫자를 저장
 *  4. 연산의 결과 M이 되었다면 BFS 탐색을 종료하고 누적연산의 결과를 answer에 저장
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
    
    static void bfs(int num) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node("", num));
        
        isVisited = new boolean[10000];
        isVisited[num] = true;
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            
            int next = operation(curr.val, 'D');
            if (!isVisited[next]) {
                if (next == M) {
                    sb.append(curr.comb).append("D");
                    break;
                } else {
                    q.offer(new Node(curr.comb + "D", next));
                    isVisited[next] = true;
                }
            }
            
            next = operation(curr.val, 'S');
            if (!isVisited[next]) {
                if (next == M) {
                    sb.append(curr.comb).append("S");
                    break;
                } else {
                    q.offer(new Node(curr.comb + "S", next));
                    isVisited[next] = true;
                }
            }
            
            next = operation(curr.val, 'L');
            if (!isVisited[next]) {
                if (next == M) {
                    sb.append(curr.comb).append("L");
                    break;
                } else {
                    q.offer(new Node(curr.comb + "L", next));
                    isVisited[next] = true;
                }
            }
            
            next = operation(curr.val, 'R');
            if (!isVisited[next]) {
                if (next == M) {
                    sb.append(curr.comb).append("R");
                    break;
                } else {
                    q.offer(new Node(curr.comb + "R", next));
                    isVisited[next] = true;
                }
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

