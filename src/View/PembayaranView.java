package View;
import Controller.Control_Pembayaran;
import Node.*;
import Model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class PembayaranView {

    Scanner scan = new Scanner(System.in);
    Control_Pembayaran controlPembayaran = new Control_Pembayaran();

    public void insertlangsungBayar(User user){
        System.out.println(" ");
        System.out.println("USER PEMBELI : "+user.getNama());
        System.out.println("=== Market =====");
        Model.modelProduk.viewAllbarang();
        System.out.println("Masukkan kode barang yang akan dibeli : ");
        int kode = scan.nextInt();
        if (Model.modelProduk.getProduk(kode) != null){
            Model.modelProduk.getProduk(kode).viewproduk();
        System.out.println("Berapakah jumlah barang yang akan dibeli : ");
        int brp = scan.nextInt();
       controlPembayaran.tambahPembayaran(user.getNama(), kode,brp);
       Model.modelProduk.commit();
        }else {
            System.out.println("BArang gaada bang");
        }
    }

//    public void insertBayarkeranjang(){
//        System.out.println(" ");
//        System.out.println("Masukkan barang yang akan di checkout : ");
//        int kode = scan.nextInt();
//    }
}
