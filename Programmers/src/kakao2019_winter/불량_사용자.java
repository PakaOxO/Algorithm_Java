package kakao2019_winter;

import java.util.HashSet;
import java.util.Set;

public class 불량_사용자 {
	static String[] sel;
	static Set<Integer> set;
	
	static boolean check(String target, String banned) {
		if (target.length() != banned.length()) return false;
		
		for (int i=0; i<target.length(); i++) {
			if (banned.charAt(i) == '*') continue;
			if (banned.charAt(i) != target.charAt(i)) return false;
		}
		return true;
	}
	
	static void dfs(String[] targets, String[] banned, int idx, int bit) {
		if (idx == banned.length) {
			set.add(bit);
			return;
		}
		
		for (int i=0; i<targets.length; i++) {
			if ((bit & 1 << i) > 0) continue;
			if (check(targets[i], banned[idx]))
				dfs(targets, banned, idx + 1, (bit | 1 << i));
		}
	}
	
	public int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<>();
        dfs(user_id, banned_id, 0, 0);
        return set.size();
    }
}
