package ders9;

public class Bmw {
	int price;
	String brand;
	String model;
	String color;

	Bmw(int price, String brand, String model, String color) {
		this.brand = brand;
		this.color = color;
		this.model = model;
		this.price = price;
	}

	void printInfo() {
		System.out.println(brand);
		System.out.println(color);
		System.out.println(model);
		System.out.println(price);
	}

	static {
		System.out.println("Bmw static kod bloku ise dusdu");
	}
	{
		System.out.println("Bmw obyekt bloku 1 ise dusdu");
	}
	{
		System.out.println("Bmw obyekt bloku 2 ise dusdu");
	}
}