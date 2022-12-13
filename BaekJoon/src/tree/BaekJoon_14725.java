package tree;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_14725, 개미굴 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. trie 알고리즘 구현하여 풀이 
 *
 */
public class BaekJoon_14725 {
    static class Node {
        Map<String, Node> childNode = new TreeMap<>();
    }
    
    static class AntCave {
        Node root = new Node();
        
        void add(String[] foods) {
            Node node = this.root;
            for (String food : foods) {
                if (!node.childNode.containsKey(food)) {
                    node.childNode.put(food, new Node());
                }
                node = node.childNode.get(food);
            }
        }
        
        void dfs(int depth, Node node) {
            Set<String> set = node.childNode.keySet();
            for (String food : set) {
                for (int i=0; i<depth; i++) answer.append("--");
                answer.append(food).append("\n");
                
                Node next = node.childNode.get(food);
                if (next.childNode.size() > 0) {
                    dfs(depth + 1, next);
                }
            }
        }
        
        void drawAntCave() {
            Node node = this.root;
            dfs(0, root);
        }
    }
    
    static StringBuilder answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        AntCave cave = new AntCave();
        answer = new StringBuilder();
        
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            
            String[] foods = new String[K];
            for (int j=0; j<K; j++) {
                foods[j] = st.nextToken();
            }
            cave.add(foods);
        }
        cave.drawAntCave();
        System.out.println(answer);
    }

}
