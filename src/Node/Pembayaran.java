package Node;
import java.time.LocalDate;
import java.util.ArrayList;

public class Pembayaran {
    public int Id;
    public int Harga;
    public User user;
    public ArrayList<Produk> listProduk;

    public Pembayaran(int id,int harga, User user, ArrayList<Produk> listProduk) {
        this.Harga = harga;
        this.Id = id;
        this.user = user;
        this.listProduk = listProduk;
    }

    public void viewBayar(){
        System.out.println("");
    }
}
