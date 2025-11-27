package gabut;

import java.util.Scanner;

public class Gabut {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        String [][] data = new String [100][3];
        int total, jumlah=0, menu, no;
        do {
            System.out.println("Pilihan Menu: "
                    + "\n1. Tambahkan data"
                    + "\n2. Urutkan data"
                    + "\n3. Hapuskan data"
                    + "\n4. Tampilkan data"
                    + "\n5. Selesai");
            System.out.print("Pilih: ");
            menu = in.nextInt();
            if (menu == 1) {
                System.out.print("Banyak data: ");
                total = in.nextInt();
                jumlah += total;
                for (int i = jumlah-total; i < jumlah; i++) {
                    System.out.print("Nama: ");
                    data[i][0] = in.next();
                    System.out.print("Kota lahir: ");
                    data[i][1] = in.next();
                    System.out.print("Status: ");
                    data[i][2] = in.next();
                }
            }
            else if (menu == 2) {
                for (int i = 0; i < jumlah - 1; i++) {
                    if (data[i][0].compareTo(data[i+1][0]) > 0) {
                        String[] temp = data[i];
                        data[i] = data[i+1];
                        data[i+1] = temp;
                    }
                    /**for (int j = 0; j < jumlah - 1 - i; j++) {
                        if (data[j][0].compareTo(data[j+1][0]) > 0) {
                            String[] temp = data[j];
                            data[j] = data[j+1];
                            data[j+1] = temp;
                        }
                    }*/
                }
                System.out.println("Data berhasil diurutkan");
            }
            else if (menu == 3) {
                System.out.print("Pilih data yang ingin dihapus (terdapat sebanyak "+ jumlah + " data): ");
                no = in.nextInt();
                if (no >= 1 && no <= jumlah) {
                    for (int i = no - 1; i < jumlah - 1; i++) {
                        data[i][0] = data[i+1][0];
                        data[i][1] = data[i+1][1];
                        data[i][2] = data[i+1][2];
                    }
                    data[jumlah-1][0] = null;
                    data[jumlah-1][1] = null;
                    data[jumlah-1][2] = null;
                    
                    jumlah--;
                    System.out.println("Data nomor-" + no + " berhasil dihapus");
                }
                else {
                    System.out.println("Input nomor tidak valid!");
                }
            }
            else if (menu == 4) {
                System.out.printf("%-15s", "No");
                System.out.printf("%-15s", "Nama");
                System.out.printf("%-15s", "Kota lahir");
                System.out.printf("%-15s", "Status");
                System.out.println("");
                for (int i = 0; i < jumlah; i++) {
                    System.out.printf("%-15s", i+1);
                    for (int j = 0; j < 3; j++) {
                        System.out.printf("%-15s", data[i][j]);
                    }
                    System.out.println("");
                }
            }
            else {
                System.out.println("Program selesai!");
            }
        } while (menu >= 1 && menu <= 4);
    }
}

