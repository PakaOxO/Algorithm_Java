package kakao2019_winter;

import java.util.ArrayList;
import java.util.List;

public class 징검다리_건너기 {
	static List<Integer>[] hPos = new ArrayList[200001];
	
	public static int solution(int[] stones, int k) {
        int min = 200000;
        int max = 0;
        for (int i=0; i<stones.length; i++) {
        	int height = stones[i];
        	if (hPos[height] == null) hPos[height] = new ArrayList<>();
        	hPos[height].add(i);
        	if (height > max) max = height;
        	if (height < min) min = height;
        }
        
        for (int h=min; h<max; h++) {
        	if (hPos[h] == null) continue;
        	
    		for (int pos : hPos[h]) {
    			int cnt = 0;
    			for (int j=pos; j<stones.length; j++) {
    				if (stones[j] > h) break;
    				
    				stones[j] = 0;
					cnt++;
					if (cnt == k) {
						return h;
					}
    			}
    		}
        }
        
        return max;
    }
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 2));
	}
}
