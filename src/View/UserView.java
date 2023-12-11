package View;
import Controller.Control_Produk;
import Controller.Control_User;
import Node.*;
import Model.*;
import modelJSON.*;
import java.util.Scanner;


public class UserView {
    ModelUser modus = new ModelUser();
    Scanner scan = new Scanner(System.in);
    Control_User con = new Control_User();


    public void ADDUSER(){
        System.out.println("==== Pembuatan username dan password ======");
        System.out.println("Masukkan username : ");
        String nm = scan.nextLine();
        System.out.println("Masukkan password : ");
        String pw = scan.nextLine();
        con.addUser(nm,pw);
        modus.viewALLuser();
    }

    public void UpdateUSER(){
        System.out.println("----- Ganti username atau pasword --------");
        modus.viewALLuser();
        int id = 0;
        System.out.println("Masukkan Id user yang ingin di UPDATE : ");
        id = scan.nextInt();
        User user = modus.getUser(id);
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
                        modus.updateNmUser(id,us);
                        System.out.println("update berhasil!!");
                        modus.commit();
                        break;
                    case 2 :
                        System.out.println("Masukkan password baru : ");
                        String pass = scan.nextLine();
                        modus.updatePASS(id,pass);
                        System.out.println("PASSWORD TELAH DIGANTI!!");
                        modus.commit();
                        break;
                }
                System.out.println("===========");
                System.out.println("Setelah diupdate : ");
                modus.listUser.get(id-1).viewUser();
                modus.commit();
            }
        }else {
            System.out.println("Barang tidak ketemuu");
        }
    }
}
