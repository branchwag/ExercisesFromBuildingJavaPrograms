public class EmployeeMain4 {
	public static void main(String[] args) {
		Employee[] employees = {new Employee(), new Lawyer(), new Secretary(), new LegalSecretary()};

		for (Employee e: employees) {
			System.out.print(e.getHours() + ", ");
			System.out.printf("$%.2f, ", e.getSalary());
			System.out.print(e.getVacationDays() + ", ");
			System.out.print(e.getVacationForm() + ", ");
			System.out.println(e);
		}
	}
}
