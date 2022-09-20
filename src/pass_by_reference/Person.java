package pass_by_reference;

public class Person {
String name;
String surname;
int experienceyear;
double salary;
int phone;
Person(String name,String surname,int experienceyear,int phone){
	this.experienceyear=experienceyear;
	this.name=name;
	this.phone=phone;
	this.surname=surname;
}

void printInfo() {
	System.out.println("name :"+name);
	System.out.println("surname :"+surname);
	System.out.println("experienceyear :"+experienceyear);
	System.out.println("salary :"+salary);
	System.out.println("phone :"+phone);
}
}
