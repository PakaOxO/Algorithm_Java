package tree;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_5052, 전화번호 목록 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. trie 알고리즘 구현하여 풀이 
 *
 */
public class BaekJoon_5052 {
    static class Node {
        Map<Character, Node> childNode = new HashMap<>();
        boolean isEnd = false;
    }
    
    static class Trie {
        Node root = new Node();
        
        void insert(String str) {
            Node node = root;
            
            for (int i=0; i<str.length(); i++) {
                char c = str.charAt(i);
                if (node.childNode.containsKey(c)) {
                    node = node.childNode.get(c);
                } else {
                    node.childNode.put(c, new Node());
                    node = node.childNode.get(c);
                }
            }
            node.isEnd = true;
        }
        
        boolean find(String str) {
            Node node = root;
            
            for (int i=0; i<str.length(); i++) {
                char c = str.charAt(i);
                if (node.childNode.containsKey(c)) {
                    node = node.childNode.get(c);
                } else
                    return false;
            }
            
            return true;
        }
    }
    
    static String[] input;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int tc=0; tc<T; tc++) {
            int N = Integer.parseInt(br.readLine());
            
            Trie trie = new Trie();
            boolean flag = false;
            
            input = new String[N];
            for (int i=0; i<N; i++) {
                String pno = br.readLine();
                input[i] = pno;
            }
            
            Arrays.sort(input, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o2.length() - o1.length();
                }
            });
            
            for (String str : input) {
                if (trie.find(str)) {
                    flag = true;
                    break;
                }
                trie.insert(str);
            }
            
            if (flag) sb.append("NO");
            else sb.append("YES");
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
