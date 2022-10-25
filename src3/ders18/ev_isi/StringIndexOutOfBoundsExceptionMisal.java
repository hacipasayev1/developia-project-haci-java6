package ders18.ev_isi;

public class StringIndexOutOfBoundsExceptionMisal {
public static void main(String[] args) {
	String c="Hesen";
	try {
	System.out.println(c.charAt(10));
	}catch(StringIndexOutOfBoundsException ex) {
		System.out.println(ex.getMessage());
	}
}
}
