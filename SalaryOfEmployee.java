import java.util.Scanner;

/* --------- BASE CLASS --------- */
class Employee {
    protected double basic;

    Employee(double basic) {
        this.basic = basic;
    }

    double getSalary() {
        return basic;
    }
}

/* --------- PERMANENT EMPLOYEE --------- */
class PermanentEmployee extends Employee {

    PermanentEmployee(double basic) {
        super(basic);
    }

    @Override
    double getSalary() {
        return basic + (basic * 0.20) - (basic * 0.10); // HRA - PF
    }
}

/* --------- CONTRACT EMPLOYEE --------- */
class ContractEmployee extends Employee {

    ContractEmployee(double basic) {
        super(basic);
    }

    @Override
    double getSalary() {
        return basic - (basic * 0.05); // Tax
    }
}

/* --------- MAIN CLASS --------- */
public class SalaryOfEmployee {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        Employee[] emp = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEmployee " + (i + 1));
            System.out.print("Enter type (1-Permanent, 2-Contract): ");
            int type = sc.nextInt();

            System.out.print("Enter basic salary: ");
            double salary = sc.nextDouble();

            if (type == 1)
                emp[i] = new PermanentEmployee(salary);
            else
                emp[i] = new ContractEmployee(salary);
        }

        int maxIndex = 0;

        System.out.println("\n----- Salary Details -----");
        for (int i = 0; i < n; i++) {
            double finalSalary = emp[i].getSalary();
            System.out.println("Employee " + (i + 1) + " Salary: " + finalSalary);

            if (finalSalary > emp[maxIndex].getSalary())
                maxIndex = i;
        }

        System.out.println("\nHighest Salary: " + emp[maxIndex].getSalary());
        sc.close();
    }
}
