package level_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 숫자배열 회전
public class SWEA_1961 {
	public static String[][] rotate90(String[][] original) {
		int N = original.length;
		String[][] rotated = new String[N][];
		for (int row=0; row<N; row++) {
			String[] newLine = new String[N];
			int idx = 0;
			for (int col=N-1; col>=0; col--) {
				newLine[idx] = original[col][row];
				idx++;
			}
			rotated[row] = newLine;
		}
		return rotated;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine());
		for (int i=0; i<testCnt; i++) {
			int N = Integer.parseInt(br.readLine());
			String[][] square = new String[N][];
			// 원본 만들기
			for (int j=0; j<N; j++) {
				String[] line = br.readLine().split(" ");
				square[j] = line;
			}
			String[][] rotated90 = rotate90(square);
			String[][] rotated180 = rotate90(rotated90);
			String[][] rotated270 = rotate90(rotated180);
			
			System.out.printf("#%d\n", i + 1);
			for (int col=0; col<N; col++) {
				System.out.printf("%s %s %s\n", String.join("",rotated90[col]), String.join("", rotated180[col]), String.join("", rotated270[col]));
			}
		}
	}

}
