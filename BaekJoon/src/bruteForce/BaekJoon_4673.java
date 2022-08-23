package bruteForce;

// 셀프넘버
public class BaekJoon_4673 {
	static boolean[] isNotSelfNumber;
	
	static void getSelfNumber(int num) {
		if (isNotSelfNumber[num]) return;
		
		while (true) {
			int temp = num;
			int next = num;
			while (temp > 0) {
				next += temp % 10;
				temp /= 10;
			}
			if (next > 10000) break;
			isNotSelfNumber[next] = true;
			num = next;
		}
	}

	public static void main(String[] args) {
		isNotSelfNumber = new boolean[10001];
		for (int i=1; i<=10000; i++) {
			getSelfNumber(i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=10000; i++) {
			if (!isNotSelfNumber[i]) sb.append(i).append("\n");
		}
		System.out.print(sb);
	}

}
