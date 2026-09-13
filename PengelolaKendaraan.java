import java.util.ArrayList;
 
public class PengelolaKendaraan {
 
    private ArrayList<KendaraanTambang> daftarKendaraan;
 
    public PengelolaKendaraan() {
        this.daftarKendaraan = new ArrayList<>();
    }
 
    public boolean tambahKendaraan(KendaraanTambang kendaraan) {
        if (cariIndexById(kendaraan.getId()) != -1) {
            return false; // ID sudah dipakai
        }
        daftarKendaraan.add(kendaraan);
        return true;
    }
 
    public void tampilkanSemuaKendaraan() {
        if (daftarKendaraan.isEmpty()) {
            System.out.println("Belum ada data kendaraan.");
            return;
        }
        System.out.println("=====================================================================");
        System.out.printf("%-8s | %-20s | %s%n", "ID", "Nama Kendaraan", "Harga Sewa/Hari");
        System.out.println("---------------------------------------------------------------------");
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            System.out.println(daftarKendaraan.get(i));
        }
        System.out.println("=====================================================================");
    }
 
    public int cariIndexById(String id) {
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            if (daftarKendaraan.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }
 
    public boolean updateKendaraan(String id, String namaBaru, double hargaBaru) {
        int index = cariIndexById(id);
        if (index == -1) {
            return false;
        }
        daftarKendaraan.get(index).setNamaKendaraan(namaBaru);
        daftarKendaraan.get(index).setHargaSewaPerHari(hargaBaru);
        return true;
    }
 
    public boolean hapusKendaraan(String id) {
        int index = cariIndexById(id);
        if (index == -1) {
            return false;
        }
        daftarKendaraan.remove(index);
        return true;
    }
 
    public int getJumlahData() {
        return daftarKendaraan.size();
    }
}
