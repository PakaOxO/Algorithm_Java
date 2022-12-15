package tree;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_14426, 접두사
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_14426 {
    static int N, M;
    
    static class Node {
        Map<Character, Node> childNode = new HashMap<>();
        boolean isEnd;
    }
    
    static class Trie {
        Node root = new Node();
        
        void insert(String word) {
            Node node = this.root;
            for (int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                if (!node.childNode.containsKey(c)) {
                    node.childNode.put(c, new Node());
                }
                node = node.childNode.get(c);
            }
        }
        
        boolean find(String word) {
            Node node = this.root;
            for (int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                if (!node.childNode.containsKey(c)) return false;
                node = node.childNode.get(c);
            }
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        Trie trie = new Trie();
        for (int i=0; i<N; i++) {
            String word = br.readLine();
            trie.insert(word);
        }
        
        int answer = 0;
        for (int i=0; i<M; i++) {
            String prefix = br.readLine();
            if (trie.find(prefix)) answer++;
        }
        System.out.println(answer);
    }

}
