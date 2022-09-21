import java.util.Arrays;

public class BItMasking_Permutation {
	static int[] nums;
	static int[] result;
	static int N;
	
	static void permutation(int idx, int isVisited) {
		System.out.println(isVisited);
		if (idx == 5) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for (int i=0; i<N; i++) {
			if ((isVisited & (1 << i)) != 0) continue;
			
			result[idx] = nums[i];
			permutation(idx + 1, isVisited | (1 << i));
		}
	}

	public static void main(String[] args) {
		N = 5;
		nums = new int[] { 1, 2, 3, 4, 5 };
		result = new int[N];
		
		permutation(0, 0);
	}

}
