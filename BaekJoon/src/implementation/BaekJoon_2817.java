package implementation;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2817, ALPS식 투표
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_2817 {
    static int X, N;
    static List<Score> scores;
    static Map<Character, Integer> map;
    
    static class Score implements Comparable<Score> {
        Character p;
        int score;
        
        Score(Character p, int score) {
            this.p = p;
            this.score = score;
        }

        @Override
        public int compareTo(Score o) {
            return o.score - this.score;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        
        scores = new ArrayList<>();
        map = new TreeMap<>();
        
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char p = st.nextToken().charAt(0);
            int votes = Integer.parseInt(st.nextToken());
            if ((votes * 100 / X) < 5) continue;
            
            for (int j=1; j<15; j++) {
                scores.add(new Score(p, votes / j));
            }
            map.put(p, 0);
        }
        
        Collections.sort(scores);
        int cnt = 0;
        for (Score s : scores) {
            int prev = map.get(s.p);
            map.put(s.p, prev + 1);
            if (++cnt == 14) break;
        }
        
        StringBuilder sb = new StringBuilder();
        Set<Character> set = map.keySet();
        for (Character p : set) {
            sb.append(p).append(" ").append(map.get(p)).append("\n");
        }
        
        System.out.println(sb.toString().trim());
    }

}
