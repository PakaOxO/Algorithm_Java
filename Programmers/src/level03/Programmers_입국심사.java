package level03;

public class Programmers_입국심사 {

	public static void main(String[] args) {
		Solution_입국심사 s = new Solution_입국심사();
		System.out.println(s.solution(6, new int[] {7, 10}));
	}

}

class Solution_입국심사 {
	public long solution(int n, int[] times) {
		return binarySearch(1L, 100000000000000000L, times, n);
	}
	
	public long binarySearch(long left, long right, int[] times, int n) {
		while (left <= right) {
			long mid = ((left + right) / 2);
			if (check(n, mid, times)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
	
	public boolean check(int n, long time, int[] times) {
		long sum = 0;
		for (int t : times) {
			sum += (time / t);
			if (sum >= n) return true;
		}
		return sum >= n;
	}
}