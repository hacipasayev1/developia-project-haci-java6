package ders18.ev_isi;

public class ArrayIndexOutOfBoundsExceptionMisal {

	public static void main(String[] args) {
		int[] massiv= {2,5,67,89};
		try {
		System.out.println(massiv[6]);
		}catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
