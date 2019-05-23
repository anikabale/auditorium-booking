package Eltech.Nesterova;
import java.sql.*;
import java.time.LocalDate;
import java.util.Date;

public class Booking {
    static int number;
    User name;
    long day;
    int time;
    int room;
    BookingStatus Status;

    Booking(User name, long day, int time, int room){
        this.name = name;
        this.day = day;
        this.time = time;
        this.room = room;
        Status = BookingStatus.Being_considered;

        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("C:/Users/Asus/Documents/LETI/web/auditoriumBooking/db/Booking","user","password");
            System.out.println("connected");

            String sql_command = "INSERT INTO bookings (userID,day,time,room,Status) VALUES ("+name.ID+", "+day+", "+time+", "+room+", '" +Status.toString()+"')";
            Statement statement = conn.createStatement();
            statement.execute(sql_command);
            ResultSet resultSet = statement.executeQuery("SELECT MAX(id) FROM bookings as ID");
            if(resultSet.next())
                this.number = resultSet.getInt(1);
            System.out.println("command executed");


            conn.close();
            System.out.println("connection closed");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    public String toString(){
        return number + " " + name + " " + room + " " + new Date(day) + " " + time;
    }

    public User getName() {
        return name;
    }

    public void setName(User name) {
        this.name = name;
    }

    public long getDay() {
        return day;
    }

    public void setDay(long day) {
        this.day = day;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public static int getNumber() {
        return number;
    }
    public void setStatus(boolean state){
        if(state){
            Status = BookingStatus.Approved;
        }
        else
        {
            Status = BookingStatus.Not_approved;
        }
    }

}

