package Eltech.Vatnik;
import java.util.Date;

public class Booking {
    static int number;
    String name;
    Date day;
    BookingTime time;
    Room room;

    Booking(String name, Date day, BookingTime time, Room room){
        number = (int)Math.random();
        this.name = name;
        this.day = day;
        this.time = time;
        this.room = room;
    }

    public String toString(){
        return number + " " + name + " " + room + " " + day.getDate() +"."+day.getMonth()+"."+(day.getYear()+1900)+ " " + time;
    }
}

