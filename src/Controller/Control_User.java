package Controller;
import Model.*;
import Node.*;

import java.util.List;

public class Control_User {

    public void addUser(String namer, String pass) {
            int id = Model.modelUser.getLasIdUser();
            id++;
        if (cekUsername(namer)|| cekPass(pass)) {
            User user = new User(id, namer, pass);
            Model.modelUser.createUser(user);
            System.out.println("Username dan password ditambahkan!!");
        } else {
            System.out.println("username atau password telah digunakan");
        }

    }

    public boolean cekUsername(String username) {
        List<User> userList = Model.modelUser.listUser;
        if (userList != null) {
            for (User user : userList) {
                if (user.getNama().equals(username)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean cekPass(String pass){
    List<User> userList = Model.modelUser.listUser;
    if (userList != null){
        for (User user: userList) {
            if (user.getPass().equals(pass)){
                return false;
            }
        }
    }
    return true;
    }

}

