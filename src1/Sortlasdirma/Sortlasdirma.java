package Sortlasdirma;

import java.util.Random;

public class Sortlasdirma {

	public static void main(String[] args) {
		int[] ededler=new int[10];
		boolean sade=true;
		Random rand=new Random();
		for(int i=0;i<ededler.length;i++) {
			ededler[i]=rand.nextInt(100)+1;
		}
		for (int a : ededler) {
			for(int i=2;i<a;i++) {
				if(a%i!=0) {
					System.out.println(a);
				}
			}
		}
	}

}
