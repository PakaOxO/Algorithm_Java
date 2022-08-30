package map;

import java.io.*;
import java.util.*;

class Date {
	int year;
	int month;
	int date;
	int hour;
	int minute;
	int second;
	
	Date(int[] data) {
		this.year = data[0];
		this.month = data[1];
		this.date = data[2];
		this.hour = data[3];
		this.minute = data[4];
	}
}

// 부품 대여장
public class BaekJoon_21942 {
	static Map<String, Map<String, Date>> users;
	static Map<String, Long> totalFee;
	static int[] dateCnt = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	static int[] getDate(String data1, String data2) {
		int[] date = new int[5];
		String[] data1Arr = data1.split("-");
		String[] data2Arr = data2.split(":");
		date[0] = Integer.parseInt(data1Arr[0]);
		date[1] = Integer.parseInt(data1Arr[1]);
		date[2] = Integer.parseInt(data1Arr[2]);
		date[3] = Integer.parseInt(data2Arr[0]);
		date[4] = Integer.parseInt(data2Arr[1]);
		
		return date;
	}
	
	static String dateDiff(Date d1, Date d2) {
		int date = 0;
		if (d2.month == d1.month) date = d2.date - d1.date;
		else {
			int m = d1.month;
			while (m < d2.month) {
				date += dateCnt[m - 1];
				m++;
			}
			date += d2.date - d1.date;
		}
		int hour = d2.hour - d1.hour;
		int minute = d2.minute - d1.minute;
		if (minute < 0) {
			minute += 60;
			hour--;
		}
		if (hour < 0) {
			hour += 24;
			date--;
		}
		return date + "/" + hour + ":" + minute;
	}
	
	static long overMinute(String rentTime, String period) {
		String[] rentDateArr = rentTime.split("/");
		String[] rentTimeArr = rentDateArr[1].split(":");
		String[] periodDateArr = period.split("/");
		String[] periodTimeArr = periodDateArr[1].split(":");
		
		int rD = Integer.parseInt(rentDateArr[0]);
		int rH = Integer.parseInt(rentTimeArr[0]);
		int rM = Integer.parseInt(rentTimeArr[1]);
		int pD = Integer.parseInt(periodDateArr[0]);
		int pH = Integer.parseInt(periodTimeArr[0]);
		int pM = Integer.parseInt(periodTimeArr[1]);
		int overD = rD - pD;
		int overH = rH - pH;
		int overM = rM - pM;
		if (overM < 0) {
			overM += 60;
			overH--;
		}
		if (overH < 0) {
			overH += 24;
			overD--;
		}
		return overM + (overH * 60) + (overD * 24 * 60);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		String period = st.nextToken();
		int fee = Integer.parseInt(st.nextToken());
		
		users = new HashMap<>();
		totalFee = new TreeMap<>((o1, o2) -> o1.compareTo(o2));
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String date = st.nextToken();
			String time = st.nextToken();
			String item = st.nextToken();
			String user = st.nextToken();
			
			// 처음 등록하는 사용자
			if (!users.containsKey(user)) {
				HashMap<String, Date> map = new HashMap<>();
				map.put(item, new Date(getDate(date, time)));
				users.put(user, map);
				continue;
			}
			// 이전에 빌렸던 물품을 다시 빌림
			if (users.get(user).get(item) == null) {
				users.get(user).put(item, new Date(getDate(date, time)));
				continue;
			}
			// 물품 반납
			if (users.get(user).get(item) != null) {
				Date fromDate = users.get(user).get(item);
				Date toDate = new Date(getDate(date, time));
				users.get(user).put(item, null);
				
				long overMinute = overMinute(dateDiff(fromDate, toDate), period);
				if (overMinute <= 0) continue;
				if (!totalFee.containsKey(user)) {
					totalFee.put(user, overMinute * fee);
				} else {
					totalFee.put(user, (totalFee.get(user) + overMinute * fee));
				}
			}
		}
		
		if (totalFee.size() > 0) {
			totalFee.forEach((user, totalF) -> {
				sb.append(user).append(" ").append(totalF).append("\n");
			});
			System.out.print(sb);
		}
		else System.out.println(-1);
		br.close();
	}

}
