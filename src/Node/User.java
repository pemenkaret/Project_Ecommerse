package Node;

public class User {
    public String nama;
    public String pass;
    public int ID;

    public User(int ID,String nama, String pass) {
        this.nama = nama;
        this.pass = pass;
        this.ID = ID;
    }

    public String getNama() {
        return nama;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPass() {
        return pass;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void viewUser(){
        System.out.println("Id User : " + ID);
        System.out.println("======");
        System.out.println("Nama User : " + nama);
        System.out.println("Password User : " + pass);
        System.out.println("=========================");
    }
}
