package ders8.object_example;

public class MainObjectExample {
public static void main(String[] args) {
	Bank bank=new Bank();
	bank.balance=100;
	System.out.println(bank.balance);
	Produkt alma=new Produkt("Quba almasi",2.5);
	Produkt alca=new Produkt("Goyce alcasi",6.5);
	Produkt heyva=new Produkt("Yumsaq heyva",2.5);
	Shopping shopping=new Shopping();
	shopping.shop(alma, bank, 1.5);
	shopping.shop(alca, bank, 3);
	shopping.shop(heyva, bank, 4);
	System.out.println(bank.balance);
	
	
}
}
