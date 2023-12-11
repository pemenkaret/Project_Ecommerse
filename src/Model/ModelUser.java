package Model;
import Node.*;
import modelJSON.*;

import java.util.ArrayList;
import java.util.List;

public class ModelUser {
    public ArrayList<User> listUser;

    modelJSon_User modelJSonUser ;

    public ModelUser(){
        modelJSonUser = new modelJSon_User();
        listUser = new ArrayList<>();
        loadProduk();
    }
    //create dan update

    public void loadProduk(){
        listUser = modelJSonUser.readJSONtofile();
    }

    public int getLasIdUser(){
        int id = 0;
        if (listUser != null) {
            for (User user : listUser) {
                id = user.getID();
            }
        }
        return id;
    }

    public User getUser(int id){
        User user = null;
        for (User use : listUser){
            if (use.getID() == id){
                return use;
            }
        }
        return user;
    }


    public boolean updateNmUser(int id,String name){
        User user = getUser(id);
        if (user != null){
            user.setNama(name);
            return true;
        }
        return false;
    }

    public boolean updatePASS(int id,String pw){
        User user = getUser(id);
        if (user.getID() == id){
            user.setPass(pw);
            return true;
        }
        return false;
    }

    public void createUser(User user){
        listUser.add(user);
        modelJSonUser.writefiletoJSON(listUser);
    }

    public void viewALLuser() {
        if (listUser != null){
            for (int i = 0; i < listUser.size(); i++) {
                loadProduk();
                listUser.get(i).viewUser();
                System.out.println("-----------------");
            }
        }
    }

    public void commit(){
        modelJSonUser.writefiletoJSON(listUser);
    }





}
