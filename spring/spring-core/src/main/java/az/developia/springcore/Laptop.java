package az.developia.springcore;

import org.springframework.stereotype.Component;

@Component(value="laptop1")
public class Laptop {
	private int price;
	private String model;


	public Laptop() {
	price=300;
	model="g22";
	}


	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Laptop(int price, String model) {
		super();
		this.price = price;
		this.model = model;
	}
	@Override
	public String toString() {
		return "Laptop [price=" + price + ", model=" + model + "]";
	}
}
