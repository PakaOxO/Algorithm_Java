package math;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_13458, 시험 감독
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 주 감독관은 필수 배치이므로 주 감독관을 먼저 배치한 뒤 감시해야할 남은 수험생의 수를 계산
 * 	2. 남은 수험생이 0보다 같거나 작다면 더 이상 배치 필요 X
 * 	3. 남은 수험생을 부 감독관의 가능 감시 인원으로 나눈 뒤, 나머지가 있으면 + 1
 *
 */
public class BaekJoon_13458 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		br.close();

		int B = Integer.parseInt(st2.nextToken());
		int C = Integer.parseInt(st2.nextToken());
		
		Map<Integer, Integer> map = new HashMap<>();
		long answer = 0;
		for (int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (map.containsKey(num)) {
				answer += map.get(num);
			} else {
				int diff = num - B;
				if (diff <= 0) map.put(num, 1);
				else {
					int s = diff / C;
					int r = diff % C;
					map.put(num, 1 + s + (r == 0 ? 0 : 1));
				}
				answer += map.get(num);
			}
		}
		
		System.out.println(answer);
	}

}
