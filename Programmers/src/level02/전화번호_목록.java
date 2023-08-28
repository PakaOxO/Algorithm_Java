package level02;

import java.util.Arrays;

class Solution_전화번호목록 {
	private boolean check(String s1, String s2) {
		int len = s1.length();
    	for (int j=0; j<len; j++) {        		
    		if (s1.charAt(j) != s2.charAt(j)) return false;
    	}
    	return true;
	}

    public boolean solution(String[] phone_book) {
    	Arrays.sort(phone_book);
    	
        for (int i=1; i<phone_book.length; i++) {
        	if (check(phone_book[i - 1], phone_book[i])) return false;
        }
        return true;
    }
}

public class 전화번호_목록 {
	public static void main(String[] args) throws Exception {
		Solution_전화번호목록 s = new Solution_전화번호목록();
		s.solution(new String[] {"119", "97674223", "1195524421"});
		s.solution(new String[] {"123","456","789"});
		s.solution(new String[] {"12","123","1235","567","88"});
	}

}