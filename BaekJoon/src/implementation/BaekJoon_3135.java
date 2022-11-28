package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BaekJoon_3135, 라디오 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 목표 주파수와의 차이가 가장 작은 값을 찾음  
 *  2. 대상은 초기 주파수, 주어진 설정 주파수 중에서 최소값을 찾음 
 *
 */
public class BaekJoon_3135 {
    static int A, B, N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());
        
        int diff_min = Math.abs(A - B);
        for (int i=0; i<N; i++) {
            diff_min = Math.min(diff_min, Math.abs(Integer.parseInt(br.readLine()) - B));
        }
        
        int answer = diff_min;
        if (diff_min != Math.abs(A - B)) {
            answer++;
        }
        System.out.println(answer);
    }

}
