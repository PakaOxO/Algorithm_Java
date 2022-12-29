package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class BaekJoon_16463 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int cnt = 0;
        int year = 2019;
        while (year <= N) {
            for (int m=1; m<=12; m++) {
                LocalDate date = LocalDate.of(year, m, 13);
                if (date.getDayOfWeek().getValue() == 5) cnt++;
            }
            year++;
        }
        System.out.println(cnt);
    }

}
