package j1;

public class textcontinue {
	public static void main(String[] args) {
		outer:for(int i=1;i<=100;i++) {
			for(int j=2;j<=i/2;j++) {
			if(i % j ==0) 
				continue outer;
			}
			System.out.println(i);
		}
	}	
}

	
