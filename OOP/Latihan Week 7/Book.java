public class Book {
    private String title;
    private String author;
    private int year;
    private String isbn;

    // Constructor untuk Class Book
    public Book (String title, String author, int year, String isbn) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
    }

    // Getter atribut Class Book
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getYear() {
        return year;
    }
    public String getISBN() {
        return isbn;
    }

    // Setter atribut Class Book
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    // Metode displayInfo() menampilkan informasi lengkap tentang buku
    public void displayInfo() {
        System.out.println("Judul: " + title);
        System.out.println("Penulis: " + author);
        System.out.println("Tahun Terbit: " + year);
        System.out.println("Nomor ISBN: " + isbn);
    }

    public static void main(String[] args) {
        // Membuat objek buku
        Book book1 = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1997, "978-0590353403");
    
        // Menampilkan informasi tentang buku
        book1.displayInfo();
        System.out.println();
    
        // Mengubah judul buku dengan setter
        book1.setTitle("Harry Potter and the Chamber of Secrets");
    
        // Mengubah tahun terbit buku dengan setter
        book1.setYear(1998);
    
        // Menampilkan informasi tentang buku setelah perubahan
        System.out.println("Informasi buku setelah perubahan:");
        book1.displayInfo();
    }
    
}