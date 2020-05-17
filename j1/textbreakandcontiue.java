package j1;

public class textbreakandcontiue {
	public static void main(String[] args) {
		for(int i =0;i<=10;i++) {
			if( i % 3 == 0) {
				continue;
			}
			System.out.println(i+"=");
		}
		for(char j ='a';j<='z';j++) {
			System.out.println(j);
			if(j ==178) {
				break;
			}
		}
	}

}
