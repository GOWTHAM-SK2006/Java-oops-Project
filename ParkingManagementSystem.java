import java.util.Scanner;


abstract class Vehicle {
    protected String number;
    protected int hours;

    Vehicle(String number, int hours) {
        this.number = number;
        this.hours = hours;
    }

    abstract int calculateFee();
    abstract void display();
}

class Bike extends Vehicle {
    Bike(String number, int hours) {
        super(number, hours);
    }

    int calculateFee() {
        return hours * 20;
    }

    void display() {
        System.out.println("Bike   " + number + "  Fee: " + calculateFee());
    }
}


class Car extends Vehicle {
    Car(String number, int hours) {
        super(number, hours);
    }

    int calculateFee() {
        return hours * 40;
    }

    void display() {
        System.out.println("Car    " + number + "  Fee: " + calculateFee());
    }
}


class Truck extends Vehicle {
    Truck(String number, int hours) {
        super(number, hours);
    }

    int calculateFee() {
        return hours * 60;
    }

    void display() {
        System.out.println("Truck  " + number + "  Fee: " + calculateFee());
    }
}


public class ParkingManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Vehicle[] park = new Vehicle[10];
        int count = 0;

        while (true) {
            System.out.println("\n1.Park Vehicle");
            System.out.println("2.Display Vehicles");
            System.out.println("3.Total Collection");
            System.out.println("4.Available Slots");
            System.out.println("5.Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            if (ch == 1) {
                if (count == 10) {
                    System.out.println("Parking Full!");
                    continue;
                }

                System.out.print("Vehicle Type (1-Bike 2-Car 3-Truck): ");
                int type = sc.nextInt();

                System.out.print("Vehicle Number: ");
                String num = sc.next();

                System.out.print("Hours Parked: ");
                int hrs = sc.nextInt();

                if (type == 1)
                    park[count++] = new Bike(num, hrs);
                else if (type == 2)
                    park[count++] = new Car(num, hrs);
                else
                    park[count++] = new Truck(num, hrs);
            }

            else if (ch == 2) {
                for (int i = 0; i < count; i++)
                    park[i].display();
            }

            else if (ch == 3) {
                int total = 0;
                for (int i = 0; i < count; i++)
                    total += park[i].calculateFee();
                System.out.println("Total Collection: ₹" + total);
            }

            else if (ch == 4) {
                System.out.println("Available Slots: " + (10 - count));
            }

            else if (ch == 5) {
                System.out.println("System Closed");
                break;
            }

            else
                System.out.println("Invalid Choice");
        }
        sc.close();
    }
}
