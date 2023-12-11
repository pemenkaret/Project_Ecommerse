package Node;

public class Produk {
    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setNamaBrand(String namaBrand) {
        this.namaBrand = namaBrand;
    }

    public void setStok(int stok) {
        Stok = stok;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getNamaBrand() {
        return namaBrand;
    }

    public int getStok() {
        return Stok;
    }



    public String namaBarang;
    public String tanggal;
    public String namaBrand;

    public int Stok,kode;

    public int getKode() {
        return kode;
    }

    public Produk(int kode, String namaBarang, String tanggal, String namaBrand, int Stok) {
        this.kode = kode;
        this.namaBarang = namaBarang;
        this.tanggal = tanggal;
        this.namaBrand = namaBrand;
        this.Stok = Stok;
    }

    public void viewProduk(){
        System.out.println(" ");
        System.out.println("Kode barang : "+ kode);
        System.out.println("---");
        System.out.println("nama Produk : "+namaBarang);
        System.out.println("tanggal diupload :"+tanggal);
        System.out.println("nama brand : "+namaBrand);
        System.out.println("stok barang : " +Stok);
    }
}
