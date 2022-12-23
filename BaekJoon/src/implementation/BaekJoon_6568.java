package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BaekJoon_6568, 귀도 반 로썸은 크리스마스날 심심하다고 파이썬을 만들었다
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_6568 {
    static int acc, pc;
    static String[] memory;
    
    static void acc(int num) {
        increasePC();
        acc += num;
        if (acc > 255)
            acc = 0;
        else if (acc < 0)
            acc = 255;
    }
    
    static void save(int addr) {
        increasePC();
        memory[addr] = Integer.toBinaryString(acc);
    }
    
    static void load(int addr) {
        increasePC();
        acc = Integer.parseInt(memory[addr], 2);
    }
    
    static void changePc(int addr, int type) {
        if (acc == 0 || type == 1) {
            pc = addr;
        } else
            increasePC();
    }
    
    static void increasePC() {
        pc++;
        if (pc >= 32) pc = 0;
    }
    
    static boolean operation(int pc) {
        String str = memory[pc];
        int op = Integer.parseInt(str.substring(0, 3), 2);
        switch(op) {
            case 0:
                save(Integer.parseInt(str.substring(3), 2));
                break;
            case 1:
                load(Integer.parseInt(str.substring(3), 2));
                break;
            case 2:
                changePc(Integer.parseInt(str.substring(3), 2), 0);
                break;
            case 3:
                increasePC();
                break;
            case 4:
                acc(-1);
                break;
            case 5:
                acc(1);
                break;
            case 6:
                changePc(Integer.parseInt(str.substring(3), 2), 1);
                break;
            case 7:
                return true;
        }
        return false;
    }
    
    static void run() {
        pc = 0;
        acc = 0;
        while (true) {
            if (operation(pc)) break;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        loop:
        while (true) {
            memory = new String[32];
            for (int i=0; i<32; i++) {
                String str = br.readLine();
                if (str == null || str.length() == 0) break loop;
                memory[i] = str;
            }
            run();
            sb.append(Integer.toBinaryString(acc)).append("\n");
        }
        System.out.println(sb);
    }

}
