import java.util.Scanner;

public class Admin extends User {

    public Admin(String name) { super(name); }

    @Override
    public void menu(Library library, Scanner sc) {
        int choice;
        do {
            System.out.println("\n--- SISTEM MANAJEMEN PERPUSTAKAAN ("+ name +") ---");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Lihat Buku Tersedia");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan Judul Buku: ");
                    String title = sc.nextLine();
                    System.out.print("Masukkan Penulis: ");
                    String author = sc.nextLine();
                    System.out.print("Masukkan ISBN: ");
                    String isbn = sc.nextLine();
                    library.addBook(new Book(isbn, title, author));
                    break;
                case 2:
                    System.out.print("Masukkan ISBN buku yang ingin dihapus: ");
                    String removeIsbn = sc.nextLine();
                    library.removeBook(removeIsbn);
                    break;
                case 3:
                    System.out.print("Masukkan judul buku yang dicari: ");
                    String searchTitle = sc.nextLine();
                    library.searchBook(searchTitle);
                    break;
                case 4:
                    library.displayBooks();
                    break;
                case 5:
                    library.displayAvailableBooks();
                    break;
            }
        } while (choice != 6);
    }
    
}
