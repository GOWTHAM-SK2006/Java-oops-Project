import java.util.Scanner;



class Person {

    private String name;         
    final int id;                 
    static String country = "India"; 

    Person(int id, String name) { 
        this.id = id;
        this.name = name;
    }  

    public String getName() {     
        return name;
    }

    String role() {
        return "Person";
    }
}


class Marks {
    private int maths;
    private int physics;
    private int chemistry;

    Marks(int maths, int physics, int chemistry) {
        this.maths = maths;
        this.physics = physics;
        this.chemistry = chemistry;
    }

    int getMaths() {
        return maths;
    }

    int getPhysics() {
        return physics;
    }

    int getChemistry() {
        return chemistry;
    }
}


class CutoffCalculator {

    double calculate(Marks m) {
        return m.getMaths() + ((m.getPhysics() + m.getChemistry()) / 2.0);
    }
}

class Student extends Person {

    Marks marks;                        
    CutoffCalculator calculator;        
    private String department;

    Student(int id, String name, Marks marks, String department) {
        super(id, name);              
        this.marks = marks;
        this.department = department;
        calculator = new CutoffCalculator();
    }

    double getCutoff() {
        return calculator.calculate(marks);
    }

    @Override
    String role() {                     
        return "Student";
    }

    void display() {
        System.out.println(
            "ID: " + id +
            " | Name: " + getName() +
            " | Dept: " + department +
            " | Cutoff: " + getCutoff() +
            " | Role: " + role()
        );
    }
}

class Department {
    String deptName;
    double cutoffLimit;

    Department(String deptName, double cutoffLimit) {
        this.deptName = deptName;
        this.cutoffLimit = cutoffLimit;
    }

    boolean isEligible(double cutoff) {
        return cutoff >= cutoffLimit;
    }
}


class College {
    static String collegeName = "Sri Sairam Engineering College";

    void admit(Student s, Department d) {
        System.out.println("\nChecking admission for " + s.getName());
        if (d.isEligible(s.getCutoff())) {
            System.out.println("ADMITTED to " + d.deptName);
        } else {
            System.out.println("NOT ELIGIBLE for " + d.deptName);
        }
    }
}

public class AdmissionSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to " + College.collegeName);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter Student Details");

            System.out.print("ID: ");
            int id = sc.nextInt();

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Maths: ");
            int m = sc.nextInt();

            System.out.print("Physics: ");
            int p = sc.nextInt();

            System.out.print("Chemistry: ");
            int c = sc.nextInt();

            System.out.print("Department: ");
            String dept = sc.next();

            Marks marks = new Marks(m, p, c);

            Person p1 = new Student(id, name, marks, dept);
            students[i] = (Student) p1;
        }

        Department cse = new Department("CSE", 180);
        College college = new College();

        System.out.println("\n===== STUDENT DETAILS =====");
        for (Student s : students) {
            s.display();
            college.admit(s, cse);
        }

        System.out.println("\nCountry (static): " + Person.country);
    }
}
