
public class MassivCalisma {
public static void main(String[] args) {
	int[] numbers=new int[5];
	numbers[0]=7;
	numbers[1]=8;
	numbers[2]=9;
	numbers[3]=10;
	numbers[4]=11;
	int c=0;
	int k=0;
	for(int i:numbers) {
				c=c+i;
				k++;
			
	}
	System.out.println("massivin butun deyerlerinin cemi"+c);
	System.out.println("massivin elementlerinin edededi ortasi"+c/k);
	
}
}
