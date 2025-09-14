import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library(10);

        // Generate contoh data buku
        library.addBook(new Book("9780134685991", "Effective Java", "Joshua Bloch"));
        library.addBook(new Book("9780596009205", "Head First Java", "Kathy Sierra, Bert Bates"));
        library.addBook(new Book("9781617294945", "Java Concurrency in Practice", "Brian Goetz"));

        // Login User
        System.out.println("Login as: 1. Admin  2. Member");
        int role = sc.nextInt();
        sc.nextLine();

        // Run aplikasi
        User user = (role == 1) ? new Admin("Admin") : new Member("Member");
        user.menu(library, sc);

        sc.close();
    }
}
