package Ders7_Ev_isi;

public class Metodlar {

	static double DaireninSahesiHesablayici(double radius) {
		double pi=3.14;
		double sahe=2*pi*radius;
		return sahe;
	}
	
	String HefteninGunu(int number) {
		if(number==1) {
			System.out.println("Bazar ertesi");
		}else if(number==2) {
			System.out.println("Cersenbe axsami");
		}else if(number==3) {
			System.out.println("Cersenbe");
		}else if(number==4) {
			System.out.println("Cume axsami");
		}else if(number==5) {
			System.out.println("Cume");
		}else if(number==6) {
			System.out.println("Senbe");
		}else if(number==7) {
			System.out.println("Bazar");
		}
	}
}
