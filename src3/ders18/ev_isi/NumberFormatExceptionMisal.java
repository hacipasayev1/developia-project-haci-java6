package ders18.ev_isi;

public class NumberFormatExceptionMisal {

	public static void main(String[] args) {
		String s="2345q";
		int c=0;
		try{
		c=Integer.parseInt(s);
		}catch(NumberFormatException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println(c);

	}

}
