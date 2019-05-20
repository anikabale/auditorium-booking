package Eltech.Vatnik;
import java.io.Console;
import java.sql.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


public class Main {

    public static void main(String[] args) {
        User user = new User("Losev","Mikhail","L'vovitch",true);
        Booking booking = new Booking(user, new Date().getTime(),1140,1054);
        System.out.println(booking.toString());
        show();


        /*try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:C:/Users/Laptop-V-Vatnik/IdeaProjects/auditoriumBooking/db/Booking","user","password");
            System.out.println("connected");

            String sql_command = "CREATE TABLE bookings(id INT PRIMARY KEY AUTO_INCREMENT, userID INT, day BIGINT,time INT,room INT, Status VARCHAR(20))";
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql_command);
            System.out.println("command executed");


            conn.close();
            System.out.println("connection closed");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }*/


/*
	    Booking test = new Booking("Ivanov Ivan Ivanovitch",new Date(),BookingTime.STARTING1140,Room.RM_03);
	    System.out.println(test);
	    //




	    test.setDay(new Calendar.Builder().setDate(2019,-1,1).build().getTime());
        System.out.println(test);
        */
    }

    public static void show(){

        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:C:/Users/Laptop-V-Vatnik/IdeaProjects/auditoriumBooking/db/Booking","user","password");
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
}
