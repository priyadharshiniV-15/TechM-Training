package TASK1;

public class Employee {
    private int empId;
    private String empName;
    private double sal;

   
    public Employee(int empId, String empName, double sal) {
        this.empId = empId;
        this.empName = empName;
        this.sal = sal;
    }

   
    public void getEmployeeDetails() {
        System.out.println("\nEmployee Details:");
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + empName);
        System.out.println("Monthly Salary: " + sal);
    }

    
    public void getLoanEligibility(int exp) {
        double annualSal = sal * 12; 

        if (exp > 5) {
            if (annualSal >= 1500000) {
                System.out.println("Eligible for 7 lakhs of loan.");
            } else if (annualSal >= 1000000) {
                System.out.println("Eligible for 5 lakhs of loan.");
            } else if (annualSal >= 600000) {
                System.out.println("Eligible for 2 lakhs of loan.");
            } else {
                System.out.println("Not eligible for a loan.");
            }
        } else {
            System.out.println("Not eligible for a loan (experience < 5 years).");
        }
    }
}
 
