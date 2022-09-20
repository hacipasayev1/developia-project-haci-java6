package pass_by_reference;

public class SalaryCalculator {
void calculateSalary(Person insan) {
	double maas=insan.experienceyear*500;
	insan.salary=maas;
}
}
