public class KendaraanTambang {
    private String id;
    private String namaKendaraan;
    private double hargaSewaPerHari;
 
    public KendaraanTambang(String id, String namaKendaraan, double hargaSewaPerHari) {
        this.id = id;
        this.namaKendaraan = namaKendaraan;
        this.hargaSewaPerHari = hargaSewaPerHari;
    }
 
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
 
    public String getNamaKendaraan() {
        return namaKendaraan;
    }
 
    public void setNamaKendaraan(String namaKendaraan) {
        this.namaKendaraan = namaKendaraan;
    }
 
    public double getHargaSewaPerHari() {
        return hargaSewaPerHari;
    }
 
    public void setHargaSewaPerHari(double hargaSewaPerHari) {
        this.hargaSewaPerHari = hargaSewaPerHari;
    }
 
    @Override
    public String toString() {
        return String.format("%-8s | %-20s | Rp %,.2f / hari", id, namaKendaraan, hargaSewaPerHari);
    }
}
