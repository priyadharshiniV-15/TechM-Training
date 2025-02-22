public class main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the employee id:");
		int empid=sc.nextInt();
		System.out.println("Enter the employee Name:");
		String empName=sc.next();
		System.out.println("Enter the employee salary:");
		double sal=sc.nextDouble();
		
		Employee e = new Employee(empid,empName,sal);

		e.getEmployeeDetails();

		System.out.println("Enter the number of years of experience:");
		int exp = sc.nextInt();
		e.getLoanEligibility(exp);
		sc.close();
	}

	
}
