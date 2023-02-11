package BaekJoon_AnimeCup2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BaekJoon_AnimeCup2_01, 고라니 커맨드 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. x축 y축 각각 이동하면서 가장 거리가 짧을 때의 x,y 값을 구하면 될 듯
 *
 */
public class BaekJoon_AnimeCup2_01 {
    static int N, M;
    static int[] answer = new int[2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int minX = 50;
        int minY = 50;
        for (int i=1; i<=N; i++) {
            if (i < N) {
                int x = Integer.parseInt(br.readLine());
                if (x < minX) {
                    minX = x;
                    answer[0] = i;
                }
            } else {
                st = new StringTokenizer(br.readLine());
                for (int j=1; j<=M; j++) {
                    int y = Integer.parseInt(st.nextToken());
                    if (j == 1) {
                        if (y < minX) {
                            minX = y;
                            answer[0] = i;
                        }
                    }
                    if (y < minY) {
                        minY = y;
                        answer[1] = j;
                    }
                }
            }
        }
        
        System.out.println(answer[0] + " " + answer[1]);
    }

}
