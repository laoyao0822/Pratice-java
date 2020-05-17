package j1;
import java.util.Scanner;

public class testif {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("你的年龄");
		int a = scanner.nextInt();
		if(a > 60) {
			System.out.println("老人");
		}else if(a > 40) {
			System.out.println("中年人");
		}else if(a> 10) {
			System.out.println("青少年");
		}else {
			System.out.println("海通");
		}
		
		
		
	}

}
