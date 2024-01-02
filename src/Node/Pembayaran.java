package Node;

import java.util.ArrayList;

public class Transaksi {
    public int Pembayaran;
    public ArrayList<Produk> listProduk;

    public Transaksi(int pembayaran, ArrayList<Produk> listProduk) {
        Pembayaran = pembayaran;
        this.listProduk = listProduk;
    }

    public int getPembayaran() {
        return Pembayaran;
    }

    public void setPembayaran(int pembayaran) {
        Pembayaran = pembayaran;
    }

    public ArrayList<Produk> getListProduk() {
        return listProduk;
    }

    public void setListProduk(ArrayList<Produk> listProduk) {
        this.listProduk = listProduk;
    }
}
