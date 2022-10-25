package ders18.ev_isi;

public class ArithmeticExceptionMisal {

	public static void main(String[] args) {
		int a=29;
		int b=0;
		int c=0;
		try{c=a/b;}catch(ArithmeticException ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println(c);

	}

}
