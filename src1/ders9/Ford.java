package ders9;

public class Ford {
	int price;
	String brand;
	String model;
	String color;
	Ford(int price,String brand,String model,String color){
		this.brand=brand;
		this.color=color;
		this.model=model;
		this.price=price;
	}
	void printInfo() {
		System.out.println(brand);
		System.out.println(color);
		System.out.println(model);
		System.out.println(price);
	}
	static {
		System.out.println("Ford static kod bloku ise dusdu");
	}
	{
		System.out.println("Ford obyekt bloku 1 ise dusdu");
	}
	{
		System.out.println("Ford obyekt bloku 2 ise dusdu");
	}
}
