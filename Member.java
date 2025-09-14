import java.util.Scanner;

public class Member extends User {
    public Member(String name) { super(name); }

    @Override
    public void menu(Library library, Scanner sc) {
        int choice;
        do {
            System.out.println("\n--- SISTEM MANAJEMEN PERPUSTAKAAN ("+ name +") ---");
            System.out.println("1. Cari Buku");
            System.out.println("2. Lihat Semua Buku");
            System.out.println("3. Pinjam Buku");
            System.out.println("4. Kembalikan Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan judul buku yang dicari: ");
                    String searchTitle = sc.nextLine();
                    library.searchBook(searchTitle);
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    System.out.print("Masukkan ISBN buku yang ingin dipinjam: ");
                    String borrowIsbn = sc.nextLine();
                    library.borrowBook(borrowIsbn);
                    break;
                case 4:
                    System.out.print("Masukkan ISBN buku yang ingin dikembalikan: ");
                    String returnIsbn = sc.nextLine();
                    library.returnBook(returnIsbn);
                    break;
            }
        } while (choice != 5);
    }
}
