// Nama : Rio Ferdinan
// NIM : 00000070666

import java.util.Random;
class Main {
    public static void main (String[] args) {
        System.out.println("Matrix");
        Random rd = new Random(); // buat Random object
        int matrix[][] = new int[3][3]; // deklarasi matriks dalam array
        for (int i=0; i<matrix.length; i++) { // loop baris
            for (int j=0; j<matrix[0].length;j++) { // loop column
                matrix[i][j] = rd.nextInt(9); // generate random number pada array
                System.out.print(matrix[i][j] + " "); // print output dari matriks
            }
            System.out.println(); // buat baris baru
        }

        System.out.println("Transpose");
        for (int i=0; i<matrix.length; i++) { // loop baris
            for (int j=0; j<matrix[0].length;j++) { // loop column
                System.out.print(matrix[j][i] + " "); // print output dari transpose matrix
            }
            System.out.println(); // buat baris baru
        }
    }
}