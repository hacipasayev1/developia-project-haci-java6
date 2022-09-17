package ders8.object_example;

public class Shopping {
void shop(Produkt produkt,Bank bank,double quantity) {
	double totalPrice=produkt.price*quantity;
	bank.drawMoney(totalPrice);
	System.out.println("alinan mehsul :"+produkt.name);
	System.out.println("umumi qiymet :"+totalPrice);
	System.out.println("bankda qalan pul :"+bank.balance);
}
}
