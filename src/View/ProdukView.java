package View;
import Controller.Control_Produk;
import Node.*;
import Model.*;
import modelJSON.*;
import java.util.Scanner;

public class ProdukView {
    modelProduk modelpro = new modelProduk();
    Scanner scan = new Scanner(System.in);
    Control_Produk controlProduk = new Control_Produk();


    public void insertProduk(){
        System.out.println("============ Tambah produk ===========");
        System.out.println("Masukkan nama Barang : ");
        String nb = scan.nextLine();
        System.out.println("Masukkan tanggal : ");
        String tg = scan.nextLine();
        System.out.println("Masukkan nama Brand : ");
        String br = scan.nextLine();
        System.out.println("Masukkan jumlah stok barang : ");
        int sk = scan.nextInt();
        System.out.println("Berapa harga barang : ");
        int hg = scan.nextInt();
        scan.nextLine();
        controlProduk.addProduk(nb,tg,br,sk,hg, 1);
        modelpro.viewAllbarang();
    }

    public void UPDATEPRODUK() {
        System.out.println(" ");
        System.out.println("---------- UPDATE PRODUK -----------");
        modelpro.viewAllbarang();
        int kd = 0;
        System.out.println("Masukkan kode barangnya : ");
        kd = scan.nextInt();
        Produk produk = modelpro.getProduk(kd);
        if (produk != null){
            System.out.println("Barang ketemu !!!");
            if (kd != -1){
                System.out.println("--SILAHKAN PILIH UPDATE --");
                System.out.println("1.nama barang");
                System.out.println("2.tanggal");
                System.out.println("3.nama brand");
                System.out.println("4.Stok");
                int pilih=0;
                System.out.println("Pilih : ");
                pilih = scan.nextInt();
                scan.nextLine();
                switch (pilih){
                    case 1:
                        System.out.println("Masukan nama barang : ");
                        String nm = scan.nextLine();
                        modelpro.updateNamaBarang(kd,nm);
                        System.out.println("Update Berhasil!!");
                        modelpro.commit();
                        break;
                    case 2:
                        System.out.println("Masukkan tanggal : ");
                        String tg = scan.nextLine();
                        modelpro.updateTanggal(kd,tg);
                        System.out.println("Update Berhasil!!");
                        modelpro.commit();
                        break;
                    case 3:
                        System.out.println("Masukkan nama Brand : ");
                        String br = scan.nextLine();
                        modelpro.updateNamaBrand(kd,br);
                        System.out.println("Update Berhasil!!");
                        modelpro.commit();
                        break;
                    case 4:
                        System.out.println("Masukkan nama stok barang : ");
                        int sk = scan.nextInt();
                        modelpro.updateStok(kd,sk);
                        System.out.println("Update Berhasil!!");
                        modelpro.commit();
                        break;
                }
                System.out.println("Setelah update !!!");
                modelpro.listproduk.get(kd-1).viewProduk();
                modelpro.commit();
            }
        }else {
            System.out.println("Barang tidak ketemu");
        }
    }

    public void DELETEPRODUK() {
        System.out.println(" ");
        System.out.println("==== Hapus Produk dengan kode ======");
        int kd=0;
        System.out.println("Masukkan kode barang : ");
        kd = scan.nextInt();
        controlProduk.deleteProduk(kd);
            }
        }
