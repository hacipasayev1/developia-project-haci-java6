package ders17_ev_isi;

public class Product {

private String name;
private double price;


public void setPrice(double price) {
	this.price=price;
}

public void setName(String name) {
	this.name=name;//niye name =name olmur?
}

public double getPrice(){
	return price;
}

public String getName(){
	return name;
}


}
