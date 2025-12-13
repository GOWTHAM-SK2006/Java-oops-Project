import java.util.Scanner;


class Course {
    final int courseId;     
    String courseName;
    static int totalCourses = 0;  
    Course(int id, String name) {
        this.courseId = id;
        this.courseName = name;
        totalCourses++;
    }
      @Override
    public String toString() {
        return "Course ID : " + courseId +
               "\nCourse Name : " + courseName + "\n";
    }

    
}


class Student {
    final int roll;       
    String name;
    Course course;      
    static int totalStudents = 0;

    Student(int roll, String name, Course course) {
        this.roll = roll;
        this.name = name;
        this.course = course;
        totalStudents++;
    }

    @Override
    public String toString() {
        return "Student Name : " + name +
               "\nRoll Number : " + roll +
               "\nCourse ID : " + course.courseId +
               "\nEnrolled Course : " + course.courseName + "\n";
    }
}


public class CollegeManager {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        Course[] courses = new Course[3];
        courses[0] = new Course(101, "Java Programming");
        courses[1] = new Course(102, "Python Essentials");
        courses[2] = new Course(103, "Data Structures");

        System.out.println("===== Available Courses =====");
        for (int i = 0; i < courses.length; i++) {
            System.out.println(courses[i]);
        }

        
        System.out.print("\nEnter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter roll number: ");
            int roll = sc.nextInt();

            System.out.print("Choose Course (1-3): ");
            int choice = sc.nextInt();
            sc.nextLine();

            Course selectedCourse = courses[choice - 1];

            students[i] = new Student(roll, name, selectedCourse);
        }

       
        System.out.println("\n===== STUDENT DETAILS =====\n");
        for (int i = 0; i < n; i++) {
            System.out.println(students[i]);
        }

        System.out.println("Total Students Created: " + Student.totalStudents);
        System.out.println("Total Courses Created  : " + Course.totalCourses);
    }
}
