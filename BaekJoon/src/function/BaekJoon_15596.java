package function;

// 정수 N개의 합
public class BaekJoon_15596 {
	public static long sum(int[] a) {
		long sum = 0;
		for (int x : a) {
			sum += x;
		}
		return sum;
	}

}
