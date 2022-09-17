package Ders7_Ev_isi;

public class Metodlar {
int m1(int begin,int end) {
	int ededi_orta=0;
	int ededsayi=0;
	int ededcemi=0;
	if(begin>end){
		
		
		
		while(end!=begin) {
	


	while(end!=0) {
		
		ededsayi++;
		int qaliq=end%10;
		
		 ededcemi+=qaliq;
		end/=10;
	}
	 ededi_orta=ededcemi/ededsayi;
	System.out.println(ededi_orta);
	end++;
	}
}else if(end>begin) {
	while(end!=begin) {
		while(end!=0) {
			
			ededsayi++;
			int qaliq=end%10;
			
			 ededcemi+=qaliq;
			end/=10;
		}
		 ededi_orta=ededcemi/ededsayi;
		System.out.println(ededi_orta);
		end++;
	}
}
}
}
