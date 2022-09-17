package Ders7_Ev_isi;

public class Metodlar {
int m1(int begin,int end) {
	int eded=0;
	int ededi_orta=0;
	int ededsayi=0;
	while(eded!=0) {
		
		ededsayi++;
		int qaliq=eded%10;
		int ededcemi=0;
		 ededcemi+=qaliq;
		 ededi_orta=ededcemi/ededsayi;
	}
	System.out.println(ededi_orta);
}
}
