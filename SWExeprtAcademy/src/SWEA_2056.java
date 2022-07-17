import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 연월일 달력 
public class SWEA_2056 {
	public static Boolean checkYMD(int year, int month, int date) {
		int[] daysOfMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (month >=1 && month <= 12 && date >= 1 && date <= 31 && date <= daysOfMonth[month - 1]) return true;
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine());
		for (int i=0; i<testCnt; i++) {
			String str = br.readLine();
			String year = str.substring(0, 4);
			String month = str.substring(4, 6);
			String date = str.substring(6);
			
			if (checkYMD(Integer.parseInt(year), Integer.parseInt(month) ,Integer.parseInt(date))) {
				System.out.printf("#%d %s/%s/%s\n", i + 1, year ,month, date);
			} else {
				System.out.printf("#%d -1\n", i + 1);
			}
		}
	}

}
