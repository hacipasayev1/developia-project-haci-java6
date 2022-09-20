package pass_by_reference;

public class MainClass {

	public static void main(String[] args) {
		Person adam=new Person("Kamil","Eliyev",10,0501234567);
		SalaryCalculator hesablayici=new SalaryCalculator();
hesablayici.calculateSalary(adam);
adam.printInfo();
	}

}
