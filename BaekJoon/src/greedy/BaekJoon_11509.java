package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BaekJoon_11509, 풍선 맞추기 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_11509 {
    static int N, answer;
    static int[] isVisited;

    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       N = Integer.parseInt(br.readLine());

       isVisited = new int[1000001];
       StringTokenizer st = new StringTokenizer(br.readLine());
       br.close();
       
       answer = 0;
       for (int i=0; i<N; i++) {
           int height = Integer.parseInt(st.nextToken());
           if (isVisited[height] == 0) {
               isVisited[height - 1]++;
               answer++;
           } else {
               isVisited[height]--;
               isVisited[height - 1]++;
           }
       }
       
       System.out.println(answer);
    }

}
