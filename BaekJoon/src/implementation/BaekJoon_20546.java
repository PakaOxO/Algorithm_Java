package implementation;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_20546, 기적의 매매법
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_20546 {
    static int[] stockCnt;
    static int[] money;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        money = new int[2];
        money[0] = money[1] = A;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        
        int upCnt = 0;
        int downCnt = 0;
        int prevPrice = 0;
        stockCnt = new int[2];
        for (int i=0; i<13; i++) {
            int price = Integer.parseInt(st.nextToken());
            
            if (i > 0) {
                if (price > prevPrice) {
                    upCnt++;
                    downCnt = 0;
                } else if (price < prevPrice) {
                    upCnt = 0;
                    downCnt++;
                } else {
                    upCnt = 0;
                    downCnt = 0;
                }
            }
            
            if (money[0] >= price) {
                int selCnt = money[0] / price;
                stockCnt[0] += selCnt;
                money[0] -= price * selCnt;
            }
            
            if (downCnt == 3) {
                if (money[1] >= price) {
                    int selCnt = money[1] / price;
                    stockCnt[1] += selCnt;
                    money[1] -= price * selCnt;
                }
            } else if (upCnt == 3) {
                money[1] += price * stockCnt[1];
                stockCnt[1] = 0;
            }
            
            prevPrice = price;
        }
        
        int lastPrice = Integer.parseInt(st.nextToken());
        int BNP = money[0] + (stockCnt[0] * lastPrice);
        int TIMING = money[1] + (stockCnt[1] * lastPrice);
        if (BNP > TIMING) {
            System.out.println("BNP");
        } else {
            if (BNP == TIMING) System.out.println("SAMESAME");
            else System.out.println("TIMING");
        }
    }

}
