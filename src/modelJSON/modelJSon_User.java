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
import java.util.Objects;

import java.io.Reader;
import java.io.*;
import java.util.ArrayList;

public class modelJSon_User {
    String fname="src/Database/User.json";
    User_JSON userJson = new User_JSON();

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

    public JSONArray convertArraylistToArrayJSON(ArrayList<User> listUser){
        if(listUser == null){
            return null;
        }else {
            JSONArray arrayUser = new JSONArray();
            for (User user : listUser){
                JSONObject obj = new JSONObject();
                obj.put(userJson.ID, user.getID());
                obj.put(userJson.nama,user.getNama());
                obj.put(userJson.pass,user.getPass());
                arrayUser.add(obj);
            }
            return arrayUser;
        }
    }

    public void writefiletoJSON(ArrayList<User> listuser){
        JSONArray arrayuser = convertArraylistToArrayJSON(listuser);
        FileWriter file = null;
        try {
            file = new FileWriter(fname);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String  gsonn = gson.toJson(arrayuser);
            file.write(gsonn);
            file.flush();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<User> convertJSONArraytoArrayList(JSONArray arr){
        if(arr == null){
            return null;
        }else {
            ArrayList<User> listUser = new ArrayList<>();
            for (int i=0;i< arr.size();i++){
                JSONObject detUser = (JSONObject) arr.get(i);
                int Id = Integer.parseInt(Objects.toString(detUser.get(userJson.ID)));
                String username = detUser.get(userJson.nama).toString();
                String pass = detUser.get(userJson.pass).toString();
                listUser.add(new User(Id,username,pass));
            }
            return listUser;
        }
    }

    public ArrayList<User> readJSONtofile(){
        if (!CekFile()){
            return null;
        }
        ArrayList<User> listUser = null;
        JSONParser parser = new JSONParser();
        try {
            Reader reader = new FileReader(fname);
            JSONArray arrayUser = (JSONArray) parser.parse(reader);
            listUser = convertJSONArraytoArrayList(arrayUser);
        } catch (FileNotFoundException e) {
            System.out.println("error: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("error: " + e.getMessage());
        } catch (IOException e){
            System.out.println("error: " + e.getMessage());
        }
        return listUser;
    }



}