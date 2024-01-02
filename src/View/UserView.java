package View;
import Controller.Control_User;
import Node.*;
import Model.*;

import java.util.ArrayList;
import java.util.Scanner;


public class UserView {
    Scanner scan = new Scanner(System.in);
    Control_User con = new Control_User();


    public void ADDUSER(){
        System.out.println("==== Pembuatan username dan password ======");
        System.out.println("Masukkan username : ");
        String nm = scan.nextLine();
        System.out.println("Masukkan password : ");
        String pw = scan.nextLine();
        con.addUser(nm,pw);
        Model.modelUser.viewALLuser();
    }

    public void UpdateUSER(){
        System.out.println("----- Ganti username atau pasword --------");
        Model.modelUser.viewALLuser();
        int id = 0;
        System.out.println("Masukkan Id user yang ingin di UPDATE : ");
        id = scan.nextInt();
        User user = Model.modelUser.getUserId(id);
        if ( user != null){
            System.out.println("ID USER DITEMUKAN!!");
            if (id != -1){
                System.out.println("PILIHAN UPDATE : ");
                System.out.println("1.Username");
                System.out.println("2.Password");
                int pilih = 0;
                System.out.print("PILIH : ");
                pilih = scan.nextInt();
                scan.nextLine();
                switch (pilih){
                    case 1 :
                        System.out.println("Masukkan username baru : ");
                        String us = scan.nextLine();
                        Model.modelUser.updateNmUser(id,us);
                        System.out.println("update berhasil!!");
                        Model.modelUser.commit();
                        break;
                    case 2 :
                        System.out.println("Masukkan password baru : ");
                        String pass = scan.nextLine();
                        Model.modelUser.updatePASS(id,pass);
                        System.out.println("PASSWORD TELAH DIGANTI!!");
                        Model.modelUser.commit();
                        break;
                }
                System.out.println("===========");
                System.out.println("Setelah diupdate : ");
                Model.modelUser.listUser.get(id-1).viewUser();
                Model.modelUser.commit();
            }
        }else {
            System.out.println("Barang tidak ketemuu");
        }
    }

    public void showKeranjang(ArrayList<Keranjang> keranjangs){
        System.out.println("======== LIST KERANJANG ===============");
        for (Keranjang barang: keranjangs) {
            System.out.println("Produk : " + barang.barang.getNamaBarang());
            System.out.println("jumlah : " + barang.jumlah);
            System.out.println("harga per barang : "+ barang.barang.getHarga());
            System.out.println("=========");
        }
    }


//    public void cekLOGIN(){
//
//    }
}
