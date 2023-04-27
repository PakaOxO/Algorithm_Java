package level02;

class Solution4 {
	int answer;
	int size;
	int[] nums;
	
	private void dfs(int sum, int depth, int target) {
		if (depth == size) {
			if (sum == target) {
				answer++;
			}
			return;
		}
		dfs(sum + nums[depth], depth + 1, target);
		dfs(sum - nums[depth], depth + 1, target);
	}
	
    public int solution(int[] numbers, int target) {
    	answer = 0;
    	nums = numbers;
    	size = nums.length;
    	dfs(0, 0, target);
    	
        return answer;
    }
}

public class 타겟넘버 {

	public static void main(String[] args) {
		Solution4 s = new Solution4();
		System.out.println(s.solution(new int[] {1, 1, 1, 1, 1}, 3));
		System.out.println(s.solution(new int[] {4, 1, 2, 1}, 4));
	}

}
