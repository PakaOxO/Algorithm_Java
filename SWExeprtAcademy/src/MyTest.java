import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MyTest {
	public static class MyClass {}
	
    public static void main(String[] args) {
    	MyClass c1 = new MyClass();
    	MyClass c2 = new MyClass();
    	MyClass c3 = c2;
    	
    	System.out.println(c1 == c2);
    	System.out.println(c1 == c3);
    	System.out.println(c2 == c3);
    	System.out.println(c1.equals(c2));
    	System.out.println(c1.equals(c3));
    	System.out.println(c2.equals(c3));
    	
    	System.out.println(c1.hashCode());
    	System.out.println(c2.hashCode());
    	System.out.println(c3.hashCode());
    }
}