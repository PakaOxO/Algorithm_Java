package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BaekJoon_22973, 점프 숨바꼭질 
 * @author PakaOxO
 * 
 * Idea
 *  1. 그림 그려보면서 규칙을 찾아내는게 중요할 듯
 *  2. 수학문제여서 탐색을 사용하면 메모리/시간 초과, 규칙성을 찾아서 풀어야 하는 문제
 *
 */
public class BaekJoon_22973 {
    static long K, answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Long.parseLong(br.readLine());
        
        if (Math.abs(K) % 2 != 0) { // K의 절댓값이 2의 배수이면 도달할 수 없으므로 분기         
            long jump = 1;
            while (jump < Math.abs(K)) { // K의 위치보다 큰 크기로 jump 해서 올 수 없음
                if (jump * 2 > Math.abs(K)) break;
                jump *= 2;
            }
            answer = 0;
            while (K != 0 && jump != 0) {
                answer++;
                if (K > 0) {
                    K -= jump;
                } else {
                    K += jump;
                }
                jump /= 2;
            }
        } else if (K == 0) {
            answer = 0;
        } else {
            answer = -1;
        }
        
        System.out.println(answer);
    }

}
