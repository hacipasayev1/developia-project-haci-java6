package constructors.home;

public class Computer {
int id;
String brand;
String model;
String color;


Computer(){
	
}
Computer(String model){
	System.out.println(model);
}
Computer(String model,String color){
	System.out.println(model);
}
}
