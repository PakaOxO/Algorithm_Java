package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 원재의 메모리 복구하기
public class SWEA_1289 {
	private static String[] line;
	private static int[] memory;
	private static int cnt;
	
	public static void resetMemory(int idx) {
		if (memory[idx] != Integer.parseInt(line[idx])) {
			if (Integer.parseInt(line[idx]) == 1) {
				for (int i=idx; i<memory.length; i++) {
					memory[i] = 1;
				}
			} else {
				for (int i=idx; i<memory.length; i++) {
					memory[i] = 0;
				}
			}
			cnt++;
		}
		
		if (idx < memory.length - 1) {
			resetMemory(idx+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			line = br.readLine().split("");
			memory = new int[line.length];
			cnt = 0;
			resetMemory(0);
			
			System.out.printf("#%d %d\n", i + 1, cnt);
		}
		br.close();
	}

}
