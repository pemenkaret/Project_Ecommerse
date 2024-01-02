package Node;

import java.util.ArrayList;

public class Produk {

    public int Stok,kode,harga;
    public String namaBarang;
    public String tanggal;
    public String namaBrand;

    public User user;
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



    public Produk(int kode, String namaBarang, String tanggal, String namaBrand, int Stok,int harga,User user) {
        this.kode = kode;
        this.namaBarang = namaBarang;
        this.tanggal = tanggal;
        this.namaBrand = namaBrand;
        this.Stok = Stok;
        this.harga =harga;
        this.user = user;
    }

    public int getKode() {
        return kode;
    }

    public void viewProduk(){
        System.out.println(" ");
        System.out.println("Kode barang : "+ kode);
        System.out.println("---");
        System.out.println("nama Produk : "+namaBarang);
        System.out.println("tanggal diupload :"+tanggal);
        System.out.println("nama brand : "+namaBrand);
        System.out.println("stok barang : " +Stok);
        System.out.println("Harga barang : " +harga);
        System.out.println("Penjual barang : "+user.getNama());
    }

    public ArrayList<Produk> viewproduk(){
        System.out.println(" ");
        System.out.println("Kode barang : "+ kode);
        System.out.println("---");
        System.out.println("nama Produk : "+namaBarang);
        System.out.println("tanggal diupload :"+tanggal);
        System.out.println("nama brand : "+namaBrand);
        System.out.println("stok barang : " +Stok);
        System.out.println("Harga barang : " +harga);
        System.out.println("Penjual      : "+user.getNama());
        return null;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
