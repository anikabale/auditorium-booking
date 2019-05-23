package Eltech.Nesterova;
import java.io.Console;
import java.sql.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


public class Main {

    public static void main(String[] args) {
        User user = new User("Ivanov", "Ivan", "Ivanovich", true);
        System.out.println(user.toString());
        showUsers();
        Booking booking = new Booking(user, new Date().getTime(), 1140, 1054);
        System.out.println(booking.toString());
        show();

    }
    public static void show(){

        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:C:/Users/Asus/Documents/LETI/web/auditoriumBooking/db/Booking","user","password");
            System.out.println("connected");

            String sql_command = "SELECT * FROM bookings";
            Statement statement = conn.createStatement();
            //statement.executeUpdate(sql_command);

            ResultSet resultSet = statement.executeQuery(sql_command);
            System.out.println("command executed");
            while(resultSet.next()) {
                System.out.println(resultSet.getInt(1)+" "+resultSet.getInt(2)+" "+new Date(resultSet.getLong(3))+" "+resultSet.getInt(4)+" "+resultSet.getInt(5)+" "+resultSet.getString(6)+" ");
            }
            conn.close();
            System.out.println("connection closed");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void showUsers(){
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("C:/Users/Asus/Documents/LETI/web/auditoriumBooking/db/Booking","user","password");
            System.out.println("connected");

            String sql_command = "SELECT * FROM users";
            Statement statement = conn.createStatement();
            //statement.executeUpdate(sql_command);

            ResultSet resultSet = statement.executeQuery(sql_command);
            System.out.println("command executed");
            while(resultSet.next()) {
                System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getBoolean(5)+" ");
            }
            conn.close();
            System.out.println("connection closed");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
