package j1;
import java.util.Scanner;

public class testscanner {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("ÇëÊäÈëÕËºÅ");
		String a = scanner.nextLine();
		System.out.println("ÇëÊäÈëÃÜÂë");
		int b = scanner.nextInt();
	    String c = b == 1609449480?"ÃÜÂëÕıÈ·":"ÃÜÂë´íÎó";
		System.out.println(c);
		
	}

}
