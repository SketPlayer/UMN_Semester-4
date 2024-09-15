public class Main2 {
    public static void main(String[] args) {
        // Membuat objek pertama
        String objek1 = new String("Nilai 1");
        // Menggunakan reference assignment untuk membuat variabel baru
        // yang merujuk pada objek yang sama dengan variabel objek1
        String objek2 = objek1;
        // Mengubah nilai variabel objek1
        objek1 = "Nilai 2";
        // Mencetak nilai kedua variabel
        System.out.println("Nilai objek1: " + objek1); // Output: Nilai 2
        System.out.println("Nilai objek2: " + objek2); // Output: Nilai 1
    }
}
