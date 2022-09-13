package constructors.home;

public class Tekrar2 {

	public static void main(String[] args) {
//		for(int i=0;i<=100;i++) {
//			double d=i/10d;
//			System.out.println(d);
//		}
//		double l=0;
//		for(int i=0;i<=100;i++) {
//			l+=0.1;
//			System.out.println(l);
//		}
		
//		int saygac=0;
//		int ededim=0;
//		while(saygac<20) {
//			ededim++;
//			int reqemcemi=0;
//			int edediminkopyasi=ededim;
//			while(edediminkopyasi!=0) {
//				reqemcemi+=edediminkopyasi%10;
//				edediminkopyasi/=10;
//			}
//			if(reqemcemi%2==0) {
//				saygac++;
//				System.out.println(ededim);
//			}
//		}
		
		
//		int saygac=0;
//		int eded=356;
//		int reqemcemi=0;
//		while(eded!=0) {
//			reqemcemi=reqemcemi+eded%10;//6 11 15
//			eded=eded/10;//35 3 0
//			saygac=saygac+1;//1 2 3
//			
//		}
//		System.out.println(reqemcemi/saygac);
//		System.out.println("bitdi");
		
//		int eded =2347;
//		int qaliq=0;
//		int enboyuk=0;
//		while(eded!=0) {
//			qaliq=eded%10;//6 5 4 3
//			if(qaliq>enboyuk)
//				
//			{enboyuk=qaliq;//6
//				}
//			eded=eded/10;//345 34 3 0
//			}
//		System.out.println(enboyuk);
//		System.out.println("bitdi");
		
		int eded=897;
		int qaliq=0;
		int enkicik=9;
		while(eded!=0) {
			qaliq=eded%10;//7 9 8
			if(qaliq<enkicik) {
				enkicik=qaliq;//7
			}
			eded=eded/10;//89 8
		}
		System.out.println(enkicik);
		System.out.println("bitdi");
	}

}
