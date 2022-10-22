package ders17_ev_isi;

public class Bank {
private double balance;//private adi deyisen ferq?

void drawMoney(double amount){
	balance=balance-amount;
}

public void setBalance(double balance) {
	this.balance=balance;
}

public double getBalance() {
	return balance;
}
}
