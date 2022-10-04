package umumipraktika;

public class MainClass {
public static void main(String[] args) {
	String sentence="Java is a high-level and class-based and object-oriented programming language that is designed to have as few implementation dependencies as possible";
	//simvol sayi
	sentence.length();
	//soz sayi
	String[] massiv=sentence.split(" ");
	int k=0;
	for (String s : massiv) {
		k++;
	}
	System.out.println(k+"soz sayi");
	
	//ramda tutdugu bit
	//sentence.length()*16;?
	
	//ilk "b simvolunun oldugu indeks
			System.out.println(sentence.indexOf("b"));
			
			//kicik simvola cevirmek
			sentence.toLowerCase();
			
			//boyuk simvola cevirmek
			sentence.toUpperCase();
			
			//class sozunun oldugunu yoxla
			sentence.contains("class");
	
}
}
