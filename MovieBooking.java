import java.util.Scanner;

class Movie {

    final int movieId;
    String name;
    int ticketPrice;

    static int totalMovies = 0;

    Movie(int id, String name, int price) {
        this.movieId = id;
        this.name = name;
        this.ticketPrice = price;
        totalMovies++;
    }

    public String toString() {
        return movieId + " - " + name + " (Rs." + ticketPrice + ")";
    }
}

class User {

    final int userId;
    String username;

    Movie movie;
    int seats;

    static int totalUsers = 0;

    User(int uid, String uname, Movie movie, int seats) {
        this.userId = uid;
        this.username = uname;
        this.movie = movie;
        this.seats = seats;
        totalUsers++;
    }

    int totalAmount() {
        return movie.ticketPrice * seats;
    }

    public String toString() {
        return "\nUser: " + username +
               "\nMovie: " + movie.name +
               "\nSeats: " + seats +
               "\nTotal Amount: Rs." + totalAmount() + "\n";
    }
}

public class MovieBooking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Movie[] movies = {
            new Movie(1, "Leo", 150),
            new Movie(2, "Jailer", 180),
            new Movie(3, "Vikram", 200),
            new Movie(4, "Master", 130)
        };

        System.out.println("========= NOW SHOWING =========");
        for (Movie m : movies) {
            System.out.println(m.toString());
        }

        System.out.print("\nEnter number of users booking: ");
        int u = sc.nextInt();
        sc.nextLine();

        User[] users = new User[u];

        for (int i = 0; i < u; i++) {

            System.out.print("\nUser ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Select movie (1-4): ");
            int choice = sc.nextInt();

            System.out.print("Enter seats: ");
            int seats = sc.nextInt();

            users[i] = new User(id, name, movies[choice - 1], seats);
        }

        System.out.println("\n========= TICKET SUMMARY =========");
        for (User user : users) {
            System.out.println(user.toString());
        }

        System.out.println("Total Movies Available: " + Movie.totalMovies);
        System.out.println("Total Users Booked   : " + User.totalUsers);
    }
}
