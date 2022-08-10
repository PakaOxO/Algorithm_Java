package pattern;

public class PatternMatching {
	
	static boolean isMatching(String str, String target) {
		int N = str.length(), M = target.length();
		int i = 0, j = 0;
		int matchCnt = 0;
		while (j < M && i < (N - M + 1)) {
			if ( !(str.charAt(i) == target.charAt(j)) ) {
				i -= j;
				j = -1;
				matchCnt = 0;
			} else {
				matchCnt++;
				if (matchCnt == M) return true;
			}
			i++;
			j++;
		}
		
		return false;
	}

	public static void main(String[] args) {
		String str = "Hello, Good Evening. World!!";
		String target = "Even";
		System.out.println(isMatching(str, target));
	}

}
