package Model;
import Node.*;
import modelJSON.*;

import java.io.IOException;
import java.util.ArrayList;

public class modelTransaksi {
    modelJSon_Pembayaran modelJSonPembayaran = new modelJSon_Pembayaran();

    public ArrayList<Pembayaran> listbayar;
  public modelTransaksi(){
      listbayar = new ArrayList<>();
      if (listbayar==null){
      listbayar= new ArrayList<>();
      }

      modelJSonPembayaran.writefileJSON(listbayar);
  }

  public boolean add
}
