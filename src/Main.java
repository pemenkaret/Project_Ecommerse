import Controller.Control_Produk;
import modelJSON.modelJSon_Produk;
import Node.*;
import org.json.simple.JSONArray;;
import Model.*;
import View.*;


import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        System.out.println("testing JSON");
        modelJSon_Produk modelJSonProduk = new modelJSon_Produk();
        modelProduk modepro = new modelProduk();
        ProdukView view = new ProdukView();
        Control_Produk controlProduk = new Control_Produk();

        UserView usview = new UserView();

        ModelUser modus = new ModelUser();
//        usview.ADDUSER();
        usview.UpdateUSER();

    }
}