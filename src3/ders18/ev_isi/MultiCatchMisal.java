package ders18.ev_isi;

public class MultiCatchMisal {
int eded;
	public static void main(String[] args) {
		MultiCatchMisal d=new MultiCatchMisal();
		String t="Arif";
		try {System.out.println(d.eded);
	System.out.println(	t.charAt(4));
		}//tek niye yazilmir
		catch(StringIndexOutOfBoundsException ex) {
			System.out.println(ex.getMessage());
		}catch(NullPointerException ex) {
			System.out.println(ex.getMessage());
		}

	}

}
