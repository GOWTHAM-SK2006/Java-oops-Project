import java.util.Scanner;

class Item {
    final int itemId;
    String name;
    double price;

    static int totalItems = 0;

    Item(int id, String name, double price) {
        this.itemId = id;
        this.name = name;
        this.price = price;
        totalItems++;
    }

    public String toString() {
        return itemId + " - " + name + " : Rs." + price;
    }
}

class Customer {
    final int custId;
    String custName;
    Item[] cart;     
    int cartSize = 0;

    static int totalCustomers = 0;

    Customer(int id, String name,int maxitem) {
        this.custId = id;
        this.custName = name;
        this.cart = new Item[maxitem];
        totalCustomers++;
    }

    void addItem(Item item) {
        cart[cartSize++] = item;
    }

    double getBill() {
        double total = 0;
        for (int i = 0; i < cartSize; i++) {
            total += cart[i].price;
        }
        return total;
    }

    public String toString() {
        String s = "\nCustomer: " + custName + "\nItems Bought:\n";
        for (int i = 0; i < cartSize; i++) {
            s += cart[i].toString() + "\n";
        }
        s += "Total Bill: Rs." + getBill() + "\n";
        return s;
    }
}

public class Supermarket {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Predefined items
        Item[] items = {
            new Item(1, "Milk", 45),
            new Item(2, "Bread", 35),
            new Item(3, "Eggs", 60),
            new Item(4, "Rice", 120),
            new Item(5, "Oil", 180)
        };

        System.out.println("========= AVAILABLE ITEMS =========");
        for (Item i : items) {
            System.out.println(i.toString());
        }

        System.out.print("\nEnter number of customers: ");
        int c = sc.nextInt();
        sc.nextLine();

        Customer[] customers = new Customer[c];

        for (int i = 0; i < c; i++) {

            System.out.println("\nEnter details for customer " + (i + 1));

            System.out.print("Customer ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            customers[i] = new Customer(id, name,5);

            System.out.print("How many items to buy? ");
            int count = sc.nextInt();

            for (int j = 0; j < count; j++) {
                System.out.print("Select item number (1-5): ");
                int choice = sc.nextInt();
                customers[i].addItem(items[choice - 1]);
            }
        }

        System.out.println("\n========== FINAL BILLS ==========");
        for (Customer cust : customers) {
            System.out.println(cust.toString());
        }

        System.out.println("Total Items in system  : " + Item.totalItems);
        System.out.println("Total Customers visited: " + Customer.totalCustomers);
    }
}
