package Eltech.Vatnik;

public class User {
    String surname,name,patronym;
    int ID;
    boolean admin;

    User(String surname,String name, String patronym,boolean admin){
        this.surname=surname;
        this.name = name;
        this.patronym = patronym;
        ID = (((((int)(surname.charAt(0)-'A')*10+(int)(name.charAt(0)-'A'))*10+((int)(patronym.charAt(0)-'A'))*10+(int)(surname.charAt(1)-'A'))*10+(int)(name.charAt(1)-'A'))*10+(int)(patronym.charAt(1)-'A'));
        this.admin=admin;
    }

    public String getName() {
        return surname+" "+name+" "+patronym;
    }

    public void setName(String surname,String name,String patronym) {
        this.surname=surname;
        this.name = name;
        this.patronym=patronym;
    }
    public boolean getAdmin(){
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
