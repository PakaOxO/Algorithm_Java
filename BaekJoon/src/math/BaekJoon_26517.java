package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BaekJoon_26517, 연속인가??
 * @author arpeg
 *
 */
public class BaekJoon_26517 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        long y1 = (long)a * k + b;
        long y2 = (long)c * k + d;
        
        if (y1 == y2) {
            System.out.println("Yes " + y1);
        } else {
            System.out.println("No");
        }
    }

}
