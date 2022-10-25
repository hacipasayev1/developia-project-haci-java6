package ders18.ev_isi;

public class NullPointerExceptionMisal {
int number;
	public static void main(String[] args) {
		
		NullPointerExceptionMisal object=null;
		try{System.out.println(object.number);
		}catch(NullPointerException ex){
			System.out.println(ex.getMessage());
		}
	}

}
