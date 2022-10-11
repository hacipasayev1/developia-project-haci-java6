package varisliktapsiriq;

public class Employee extends Person {
	 int salary;
	int department;
	String username;
	String password;
	
	void printInfo() {
		super.printInfo();
		System.out.println(salary);
		System.out.println(department);
		System.out.println(username);
		System.out.println(password);
	}
}
