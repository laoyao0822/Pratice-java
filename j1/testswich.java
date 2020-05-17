package j1;

public class testswich {
	public static void main(String[] args) {
		int math =(int)(1+120*Math.random());
		char garde;
		if(math < 60) {
			 garde = 'b';
		}else {
			 garde='a';
		}
		switch(garde) {
		case'a':System.out.println("还需要努力");break;
		case 'b':System.out.println("怎么考这么差");break;
			
			
		}
		System.out.println(math);
	}

}
