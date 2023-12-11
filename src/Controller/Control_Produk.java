
package Controller;
import Model.*;
import Node.*;

import java.io.IOException;

public class Control_Produk {
    modelProduk modelpro = new modelProduk();
    public void addProduk(String nama, String tgl, String brand, int stok){
        int kode = modelpro.getLastkode();
        kode++;
        Produk newProduk = new Produk(kode, nama, tgl, brand, stok);
        modelpro.tambahBarang(newProduk);
        System.out.println("berhasil ditambahkan");
    }

    public Boolean deleteProduk(int kode) {
        Boolean del = modelpro.delete(kode);
        if (del){
            modelpro.commit();
            System.out.println("Delete berhasil !!!");
            modelpro.viewAllbarang();
        }else {
            System.out.println("barang tidak ketemu");
        }
        return del;
    }

//    public boolean updateProduk(int kode,String nama,String tanggal,String namabrand,int stok){
//        Boolean up = modelpro.update(kode, nama,tanggal,namabrand,stok);
//        if (up){
//            System.out.println("UPDATE BERHASIL!!!");
//            Produk produk = modelpro.getProduk(kode);
//            System.out.println("ini adalah tampilan update barang dari kode " + kode);
//            System.out.print(produk.kode+" ");
//            System.out.print(produk.namaBarang+" ");
//            System.out.print(produk.tanggal+" ");
//            System.out.print(produk.namaBrand+" ");
//            System.out.print(produk.Stok+" ");
//        } else {
//            System.out.println("Tidak ada barang!!");
//        }
//        return up;
//    }

//    public Produk Searchkode(int kode){
//        Produk pro = modelpro.getProduk(kode);
//        if (pro != null){
//            System.out.println("kode "+pro.getKode() +", judul buku : "+pro.getNamaBarang()+", tanggal uplod : "+pro.getTanggal()+", Nama Brand : "+pro.getNamaBrand()+", Stok : "+pro.getStok());
//        } else {
//            System.out.println("buku tidak ketemu");
//        }
//        return pro;
//    }

}
