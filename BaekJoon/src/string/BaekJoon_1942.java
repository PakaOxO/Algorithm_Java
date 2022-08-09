package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// µðÁöÅÐ½Ã°è
public class BaekJoon_1942 {
	static int[] time1;
	static int[] time2;
	static int answer;
	
	static int getNumber(int h, int m, int s) {
		return (h * 10000) + (m * 100) + s;
	}
	
	static void getList() {
		if ( getNumber(time1[0], time1[1], time1[2]) >  getNumber(time2[0], time2[1], time2[2])) {
			while (getNumber(time1[0], time1[1], time1[2]) < 240000) {
				int number = getNumber(time1[0], time1[1], time1[2]);
				if (number % 3 == 0) answer++;
				time1[2]++;
				if (time1[2] >= 60) {
					time1[2] = 0;
					time1[1]++;
				}
				if (time1[1] >= 60) {
					time1[1] %= 60;
					time1[0]++;
				}
			}
			while (getNumber(time2[0], time2[1], time2[2]) >= 0) {
				int number = getNumber(time2[0], time2[1], time2[2]);
				if (number % 3 == 0) answer++;
				time2[2]--;
				if (time2[2] < 0) {
					time2[2] += 60;
					time2[1]--;
				}
				if (time2[1] < 0) {
					time2[1] += 60;
					time2[0]--;
				}
			}
		} else {
			while (getNumber(time1[0], time1[1], time1[2]) <= getNumber(time2[0], time2[1], time2[2])) {
				int number = getNumber(time1[0], time1[1], time1[2]);
				if (number % 3 == 0) answer++;
				time1[2]++;
				if (time1[2] >= 60) {
					time1[2] = 0;
					time1[1]++;
				}
				if (time1[1] >= 60) {
					time1[1] %= 60;
					time1[0]++;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 3;
		for (int i=0; i<T; i++) {
			answer = 0;
			time1 = new int[3];
			time2 = new int[3];
			StringTokenizer st = new StringTokenizer(br.readLine());
			String[] input1 = st.nextToken().split(":");
			String[] input2 = st.nextToken().split(":");
			for (int j=0; j<3; j++) {
				time1[j] = Integer.parseInt(input1[j]);
				time2[j] = Integer.parseInt(input2[j]);
			}
			getList();
			System.out.println(answer);
		}
		br.close();
	}

}
