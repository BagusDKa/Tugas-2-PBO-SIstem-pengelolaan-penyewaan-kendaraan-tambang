import java.util.Scanner;
 
public class Main {
 
    private static Scanner scanner = new Scanner(System.in);
    private static PengelolaKendaraan pengelola = new PengelolaKendaraan();
 
    public static void main(String[] args) {
        int pilihan;
 
        do {
            tampilkanMenu();
            pilihan = bacaPilihanMenu();
 
           
            switch (pilihan) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    pengelola.tampilkanSemuaKendaraan();
                    break;
                case 3:
                    updateData();
                    break;
                case 4:
                    hapusData();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan sistem. Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih menu 1-5.");
            }
            System.out.println();
        } while (pilihan != 5);
 
        scanner.close();
    }
 
    private static void tampilkanMenu() {
        System.out.println("=========================================================");
        System.out.println("   SISTEM PENGELOLAAN PENYEWAAN KENDARAAN TAMBANG");
        System.out.println("=========================================================");
        System.out.println("1. Tambah Data Kendaraan");
        System.out.println("2. Tampilkan Semua Data Kendaraan");
        System.out.println("3. Update Data Kendaraan");
        System.out.println("4. Hapus Data Kendaraan");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu (1-5): ");
    }
 
    
    private static int bacaPilihanMenu() {
        int pilihan = -1;
        boolean valid = false;
        while (!valid) {
            try {
                pilihan = Integer.parseInt(scanner.nextLine().trim());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.print("Input harus berupa angka! Coba lagi: ");
            }
        }
        return pilihan;
    }
 
    private static void tambahData() {
        System.out.println("--- Tambah Data Kendaraan ---");
        String id = bacaStringTidakKosong("Masukkan ID Kendaraan: ");
 
        if (pengelola.cariIndexById(id) != -1) {
            System.out.println("Gagal! ID sudah digunakan, silakan gunakan ID lain.");
            return;
        }
 
        String nama = bacaStringTidakKosong("Masukkan Nama Kendaraan: ");
        double harga = bacaDoublePositif("Masukkan Harga Sewa per Hari: ");
 
        KendaraanTambang kendaraan = new KendaraanTambang(id, nama, harga);
        pengelola.tambahKendaraan(kendaraan);
        System.out.println("Data berhasil ditambahkan.");
    }
 
    private static void updateData() {
        System.out.println("--- Update Data Kendaraan ---");
        if (pengelola.getJumlahData() == 0) {
            System.out.println("Belum ada data untuk diupdate.");
            return;
        }
 
        pengelola.tampilkanSemuaKendaraan();
        String id = bacaStringTidakKosong("Masukkan ID Kendaraan yang akan diupdate: ");
 
        if (pengelola.cariIndexById(id) == -1) {
            System.out.println("Data dengan ID tersebut tidak ditemukan.");
            return;
        }
 
        String namaBaru = bacaStringTidakKosong("Masukkan Nama Kendaraan Baru: ");
        double hargaBaru = bacaDoublePositif("Masukkan Harga Sewa per Hari Baru: ");
 
        pengelola.updateKendaraan(id, namaBaru, hargaBaru);
        System.out.println("Data berhasil diupdate.");
    }
 
    private static void hapusData() {
        System.out.println("--- Hapus Data Kendaraan ---");
        if (pengelola.getJumlahData() == 0) {
            System.out.println("Belum ada data untuk dihapus.");
            return;
        }
 
        pengelola.tampilkanSemuaKendaraan();
        String id = bacaStringTidakKosong("Masukkan ID Kendaraan yang akan dihapus: ");
 
        boolean berhasil = pengelola.hapusKendaraan(id);
        if (berhasil) {
            System.out.println("Data berhasil dihapus.");
        } else {
            System.out.println("Data dengan ID tersebut tidak ditemukan.");
        }
    }
 
   
    private static String bacaStringTidakKosong(String pesan) {
        String input;
        while (true) {
            System.out.print(pesan);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                break;
            }
            System.out.println("Input tidak boleh kosong! Coba lagi.");
        }
        return input;
    }
 
    
    private static double bacaDoublePositif(String pesan) {
        double nilai = -1;
        boolean valid = false;
        while (!valid) {
            System.out.print(pesan);
            try {
                nilai = Double.parseDouble(scanner.nextLine().trim());
                if (nilai <= 0) {
                    System.out.println("Harga harus lebih dari 0! Coba lagi.");
                } else {
                    valid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka! Coba lagi.");
            }
        }
        return nilai;
    }
}
