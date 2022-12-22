package kakao2019_winter;

public class 징검다리_건너기 {
	public static int solution(int[] stones, int k) {
		int answer = Integer.MAX_VALUE;
		for (int i=0; i<stones.length; i++) {
			if (stones[i] >= answer) continue;
			int cnt = 0;
			for (int j=i; j<stones.length; j++) {
				if (stones[j] > stones[i]) break;
				cnt++;
				if (cnt == k) {
					answer = Math.min(answer, stones[i]);
					break;
				}
			}
		}
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
	}
}
