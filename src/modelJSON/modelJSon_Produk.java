package modelJSON;
import  Node.*;
import NodeJSON.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JsonArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.*;

import java.io.Reader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class modelJSon_Produk {
    Produk_JSon produkJSon = new Produk_JSon();
    String fname="src/Database/Produk.json";

    public boolean CekFile() {
        boolean cek = false;
        try {
            java.io.File file = new java.io.File(fname);
            if (file.exists()) {
                cek = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cek;
    }

    public JSONArray convertArraylistToArrayJSON(ArrayList<Produk> listproduk){
        if(listproduk == null){
            return null;
        }else {
            JSONArray arrayproduk = new JSONArray();
            for (Produk produk : listproduk){
                JSONObject obj = new JSONObject();
                obj.put(produkJSon.kode,produk.getKode());
                obj.put(produkJSon.namaBarang,produk.getNamaBarang());
                obj.put(produkJSon.tanggal,produk.getTanggal());
                obj.put(produkJSon.namaBrand,produk.getNamaBrand());
                obj.put(produkJSon.Stok,produk.getStok());
                arrayproduk.add(obj);
            }
            return arrayproduk;
        }
    }

    public void writefileJSON(ArrayList<Produk> listproduk){
        JSONArray arrayproduk2 = convertArraylistToArrayJSON(listproduk);
        FileWriter file = null;
        try {
            file = new FileWriter(fname);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String  gsonn = gson.toJson(arrayproduk2);
            file.write(gsonn);
            file.flush();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Produk> convertJSONArraytoArrayList(JSONArray array){
        if(array == null){
            return null;
        }else {
            ArrayList<Produk> listProduk = new ArrayList<>();
            for (int i=0;i< array.size();i++){
                JSONObject detProduk = (JSONObject) array.get(i);
                int Kode = Integer.parseInt(detProduk.get(produkJSon.kode).toString());
                String namaBarang = detProduk.get(produkJSon.namaBarang).toString();
                String tanggal = detProduk.get(produkJSon.tanggal).toString();
                String namabrand = detProduk.get(produkJSon.namaBrand).toString();
                int stok = Integer.parseInt(detProduk.get(produkJSon.Stok).toString());
                listProduk.add(new Produk(Kode,namaBarang,tanggal,namabrand,stok));
            }
            return listProduk;
        }
    }

    public ArrayList<Produk> readJSON(){
        if (!CekFile()){
            return null;
        }
        ArrayList<Produk> listBarang = null;
        JSONParser parser = new JSONParser();
        try {
            Reader reader = new FileReader(fname);
            JSONArray arrayBarang = (JSONArray) parser.parse(reader);
            listBarang = convertJSONArraytoArrayList(arrayBarang);
        } catch (FileNotFoundException e) {
            System.out.println("error: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("error: " + e.getMessage());
        } catch (IOException e){
            System.out.println("error: " + e.getMessage());
        }
        return listBarang;
    }
//
//    public boolean deletebynameJSON(String namaa) throws IOException {
//        List<Produk> listnama = readJSON();
//
//        if (listnama != null){
//            if (listnama.removeIf(Produk -> Produk.getNamaBarang() == namaa )){
//                writefileJSON((ArrayList<Produk>) listnama);
//                System.out.println("delet berhasil");
//                return true;
//            } else {
//                System.out.println("nama tidak ditemukan");
//                return false;
//            }
//        }
//        System.out.println("data barang kosong");
//        return false;
//    }

//    public boolean updateJSONnamabarang(String namalama,String newName) throws IOException {
//        ArrayList <Produk> listnama = readJSON();
//
//        if(listnama != null){
//            for (int i = 0 ; i < listnama.size(); i++){
//                if (namalama.equals(listnama.get(i).getNamaBarang())){
//                    listnama.get(i).setNamaBarang(newName);
//                    writefileJSON(listnama);
//                    System.out.println("Data anda sudah di update!!");
//                    return true;
//                }
//            }
//        }
//        System.out.println("nama barang tidak ada ");
//        return false;
//    }

//    public boolean updateStokBarangJSON(String nama, int stok) throws IOException {
//        ArrayList<Produk> listStok = readJSON();
//
//        if(listStok != null){
//            for (int i=0; i < listStok.size();i++){
//                if (listStok.get(i).getNamaBarang().equals(nama)){
//                    listStok.get(i).setStok(stok);
//                    writefileJSON(listStok);
//                    System.out.println("data sudah diperbaharui!!!");
//                    return true;
//                }
//            }
//        }
//        System.out.println("STOK BARANG KOSONG!!");
//        return false;
//    }

    }


