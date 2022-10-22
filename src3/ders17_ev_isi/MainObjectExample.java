package ders17_ev_isi;

public class MainObjectExample {

	public static void main(String[] args) {
	Bank bank1=new Bank();
	Bank bank2=new Bank();
	Bank bank3=new Bank();
	
	bank1.setBalance(100);
	bank2.setBalance(200);
	bank3.setBalance(300);
	
	Product alma=new Product();
	Product alca=new Product();
    Product heyva=new Product();
	
	alma.setPrice(2.5);
	alma.setName("quba alma");
	
	alca.setName("goyce alca");
	alca.setPrice(6.5);
	
	heyva.setName("yumsaq heyva");
	heyva.setPrice(3.5);
	
	Shopping shopping=new Shopping();
	
	shopping.shop(alma, bank1, 1.5);
	shopping.shop(alca, bank2, 3);
	shopping.shop(heyva, bank3, 4);
	


	}

}
