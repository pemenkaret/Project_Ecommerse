package Model;
import Node.*;
import modelJSON.*;

import java.io.IOException;
import java.util.ArrayList;

public class modelProduk {
  //tambah data,hapus,update
    public ArrayList<Produk> listproduk;
    modelJSon_Produk modelJSon_produk;


    public modelProduk(){
      listproduk = new ArrayList<>();
      modelJSon_produk = new modelJSon_Produk();
      loadProduk();
    }

    public void loadProduk(){
      listproduk = modelJSon_produk.readJSON();
    }

//    public ArrayList<Produk> GetProduk(){
//      return listproduk;
//    }

    public int getLastkode(){
      int last = listproduk.size() - 1;
      return listproduk.get(last).getKode();
    }

    public void commit(){
      modelJSon_produk.writefileJSON(listproduk);
    }

    public Produk getProduk(int kode){
      Produk produks = null;
      for (Produk produk: listproduk){
        if(produk.getKode()==kode){
          return produk;
        }
      }
      return produks;
    }

  public void tambahBarang(Produk nodeProduk) {
      listproduk.add(nodeProduk);
    modelJSon_produk.writefileJSON(listproduk);
  }


//  public boolean update(int kode,String nama,String tanggal,String namabrand,int stok){
//    Produk produk = getProduk(kode);
//    if (produk != null) {
//      produk.namaBarang = nama;
//      produk.tanggal = tanggal;
//      produk.namaBrand = namabrand;
//      produk.Stok = stok;
//      return true;
//    }
//    return false;
//    }

    public boolean delete(int kode){
      Produk produk = getProduk(kode);
      if (produk != null){
        listproduk.remove(produk);
        return true;
      }
      return false;
    }

    public void viewAllbarang() {
      for (int i = 0; i < listproduk.size(); i++) {
        loadProduk();
        listproduk.get(i).viewProduk();
        System.out.println("-----------------");
      }
    }

  // Metode untuk mengupdate nama barang
  public boolean updateNamaBarang(int kode, String nama) {
    Produk produk = getProduk(kode);
    if (produk != null) {
      produk.setNamaBarang(nama);
      return true;
    }
    return false;
  }

  // Metode untuk mengupdate tanggal
  public boolean updateTanggal(int kode, String tanggal) {
    Produk produk = getProduk(kode);
    if (produk != null) {
      produk.setTanggal(tanggal);
      return true;
    }
    return false;
  }

  // Metode untuk mengupdate nama brand
  public boolean updateNamaBrand(int kode, String namaBrand) {
    Produk produk = getProduk(kode);
    if (produk != null) {
      produk.setNamaBrand(namaBrand);
      return true;
    }
    return false;
  }

  // Metode untuk mengupdate stok
  public boolean updateStok(int kode, int stok) {
    Produk produk = getProduk(kode);
    if (produk != null) {
      produk.setStok(stok);
      return true;
    }
    return false;
  }


//  public boolean updatePRODUKNEW(int kode, String nama, String tanggal, String namaBrand, int stok) {
//    // Gunakan metode-metode di atas sesuai dengan atribut yang ingin diupdate
//    boolean updatedNama = updateNamaBarang(kode, nama);
//    boolean updatedTanggal = updateTanggal(kode, tanggal);
//    boolean updatedBrand = updateNamaBrand(kode, namaBrand);
//    boolean updatedStok = updateStok(kode, stok);
//    // Return true jika setidaknya satu atribut berhasil diupdate
//    return updatedNama || updatedTanggal || updatedBrand || updatedStok;
//  }


//    public void updateNameBarang(int kode, String newname){
//      for (int i=0;i<listproduk.size();i++){
//        if (){
//
//        }
//      }
//      }

//      public int SearchBarang(int kode){
//      for (int i=0;i<listproduk.size();i++){
//        if (listproduk.get(i).equals(listproduk.get(i).getKode())){
//
//        }
//      }
//      }

}
