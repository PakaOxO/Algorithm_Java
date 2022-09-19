package math;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BaekJoon_11005, 진법 변환 2
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 진법변환 복습 필요...
 * 	2. B진법으로 나타내야 하므로 B로 나눈 나머지를 가지고 진법 변환
 * 	3. 나머지는 나누고 남은 수이므로 진법 변환딘 위치의 숫자값을 의미
 * 	4. N을 B로 나눌 때마다 자리가 하나씩 이동(우에서 좌로)
 *
 */
public class BaekJoon_11005 {

	public static String conversion(int number, int N){
        StringBuilder sb = new StringBuilder();
	    
        // 진법 변환할 숫자가 0보다 큰 경우 지속 진행
        while(number > 0){
            // 만약 N으로 나누었는데 10보다 작다면 해당 숫자를 바로 append
            if(number % N < 10){
                sb.append(number % N);
                
            // 만약 N이 10보다 큰 경우, N으로 나누었는데 10 이상이면 A, B등으로 표현하므로 기존 숫자는 10진법이므로 10만큼 빼고 'A'를 더한다. 
            // 왜냐면 1~9까지는 숫자로 표기하지만, 10 부터는 'A', 'B' 순서로 나타내기 때문이다.
            // 나머지가 10이라면 'A' + 10이 아니라 'A'로 나타내야 하기 때문
            } else {
                sb.append((char)(number % N - 10 + 'A'));
            }
            number /= N;
        }
        // StringBuilder의 reverse를 사용해야 정상적으로 출력 가능. 안그러면 거꾸로 출력됨
        return sb.reverse().toString();
    }
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		System.out.println(conversion(N, B));
		br.close();
	}

}
