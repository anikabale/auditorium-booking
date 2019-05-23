package Eltech.Nesterova;

import java.sql.*;

public class User {
    String surname,name,patronym;
    int ID;
    boolean admin;

    User(String surname,String name, String patronym,boolean admin){
        this.surname=surname;
        this.name = name;
        this.patronym = patronym;
        this.admin=admin;

        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("C:/Users/Asus/Documents/LETI/web/auditoriumBooking/db/Booking","user","password");
            System.out.println("connected");

            String sql_command = "INSERT INTO users (name, surname, patronym, admin) VALUES ('"+name+"', '"+surname+"', '"+patronym+"', "+admin+")";
            Statement statement = conn.createStatement();
            statement.execute(sql_command);
            ResultSet resultSet = statement.executeQuery("SELECT MAX(id) FROM users as ID");
            if(resultSet.next())
                this.ID = resultSet.getInt(1);
            System.out.println("command executed");


            conn.close();
            System.out.println("connection closed");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }

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

    @Override
    public String toString() {
        return ""+ID+" "+surname+" "+name+" "+patronym+" admin - "+admin;
    }
}
