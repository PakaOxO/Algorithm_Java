package level_04;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 카드제거
public class SWEA_14557 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine());
		for (int i=0; i<testCnt; i++) {
			String[] arr = br.readLine().split("");
			boolean hasCard;
			boolean canRemove;
			String result;
			loopname:
			while (true) {
				hasCard = false;
				canRemove = false;
				for (int idx=0; idx<arr.length; idx++) {
					if (!arr[idx].equals("2")) hasCard = true;
					if (arr[idx].equals("1")) canRemove = true;
					
					if (idx > 0 && idx < arr.length - 1) {
						if (arr[idx].equals("1")) {
							arr[idx] = "2";
							if (arr[idx - 1].equals("0")) arr[idx - 1] = "1";
							if (arr[idx + 1].equals("0")) arr[idx + 1] = "1";
						}
					} else {
						if (idx == 0) {
							if (arr[idx].equals("1")) {
								arr[idx] = "2";
								if (arr[idx + 1].equals("0")) arr[idx + 1] = "1";
							}
						} else {
							if (arr[idx].equals("1")) {
								arr[idx] = "2";
								if (arr[idx - 1].equals("0")) arr[idx + 1] = "1";
							}
						}
					}
					System.out.println(Arrays.toString(arr));
					if (idx == arr.length - 1) {
						if (!hasCard && !canRemove) {
							result = "Yes";
							break loopname;
						}
						
						if (hasCard && !canRemove) {
							result = "No";
							break loopname;
						}
					}
				}
			}
			System.out.printf("#%d %s\n", i + 1, result);
		}
	}

}
