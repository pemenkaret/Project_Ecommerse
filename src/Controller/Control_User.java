package Controller;
import modelJSON.*;
import Model.*;
import Node.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Control_User {
    ModelUser modelUser;
    public Control_User(){
        this.modelUser = new ModelUser();
    }

    public void addUser(String namer, String pass) {
            int id = modelUser.getLasIdUser();
            id++;
        if (cekUsername(namer)) {
            User user = new User(id, namer, pass);
            modelUser.createUser(user);
            System.out.println("barang ditambahkan");
        } else {
            System.out.println("username telah digunakan");
        }

    }

    public boolean cekUsername(String username) {
        List<User> userList = modelUser.listUser;
        if (userList != null) {
            for (User user : userList) {
                if (user.getNama().equals(username)) {
                    return false;
                }
            }
        }
        return true;
    }
}

