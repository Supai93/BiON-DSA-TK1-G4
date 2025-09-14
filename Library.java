public class Library {
    private Book[] books;
    private int totalBooks;

    public Library(int capacity) {
        books = new Book[capacity];
        totalBooks = 0;
    }

    // Tambah buku baru
    public void addBook(Book newBook) {
        if (totalBooks < books.length) {
            books[totalBooks] = newBook;
            totalBooks++;
            System.out.println("Buku berhasil ditambahkan: " + newBook.getTitle());
        } else {
            System.out.println("Perpustakaan penuh! Tidak bisa menambahkan buku baru.");
        }
    }

    // Hapus buku berdasarkan ISBN
    public void removeBook(String isbn) {
        boolean found = false;
        for (int i = 0; i < totalBooks; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                found = true;
                System.out.println("Buku dihapus: " + books[i].getTitle());
                // Geser array
                for (int j = i; j < totalBooks - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[totalBooks - 1] = null;
                totalBooks--;
                break;
            }
        }
        if (!found) {
            System.out.println("Buku dengan ISBN " + isbn + " tidak ditemukan.");
        }
    }

    // Cari buku berdasarkan judul
    public void searchBook(String title) {
        boolean found = false;
        for (int i = 0; i < totalBooks; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                System.out.println("Buku ditemukan: " + books[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Buku dengan judul \"" + title + "\" tidak ditemukan.");
        }
    }

    // Tampilkan semua buku
    public void displayBooks() {
        if (totalBooks == 0) {
            System.out.println("Tidak ada buku di perpustakaan.");
            return;
        }
        System.out.println("Daftar Buku:");
        for (int i = 0; i < totalBooks; i++) {
            System.out.println((i + 1) + ". " + books[i]);
        }
    }

    // Tampilkan buku yang tersedia (belum dipinjam)
    public void displayAvailableBooks() {
        boolean hasAvailable = false;
        System.out.println("Daftar Buku Tersedia:");
        for (int i = 0; i < totalBooks; i++) {
            if (!books[i].isBorrowed()) {
                System.out.println((i + 1) + ". " + books[i]);
                hasAvailable = true;
            }
        }
        if (!hasAvailable) {
            System.out.println("Tidak ada buku yang tersedia saat ini.");
        }
    }

    // Pinjam buku berdasarkan ISBN
    public void borrowBook(String isbn) {
        for (int i = 0; i < totalBooks; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                if (!books[i].isBorrowed()) {
                    books[i].borrowBook();
                    System.out.println("Berhasil meminjam buku: " + books[i].getTitle());
                } else {
                    System.out.println("Buku " + books[i].getTitle() + " sedang dipinjam.");
                }
                return;
            }
        }
        System.out.println("Buku dengan ISBN " + isbn + " tidak ditemukan.");
    }

    // Kembalikan buku berdasarkan ISBN
    public void returnBook(String isbn) {
        for (int i = 0; i < totalBooks; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                if (books[i].isBorrowed()) {
                    books[i].returnBook();
                    System.out.println("Buku berhasil dikembalikan: " + books[i].getTitle());
                } else {
                    System.out.println("Buku " + books[i].getTitle() + " sudah tersedia.");
                }
                return;
            }
        }
        System.out.println("Buku dengan ISBN " + isbn + " tidak ditemukan.");
    }
}
