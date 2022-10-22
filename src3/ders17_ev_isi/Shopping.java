package ders17_ev_isi;

public class Shopping {
void shop(Product product,Bank bank,double quantity) {
	double totalPrice=product.getPrice()*quantity;
	System.out.println("alinan mehsul: "+product.getName());
	System.out.println("umumi qiymet: "+totalPrice);
	
	bank.drawMoney(totalPrice);
	System.out.println("bankda qalan pul: "+bank.getBalance());
}
}
