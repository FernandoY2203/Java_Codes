
package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.exceptions.DomainException;

public class Reservation {
    private Integer roomNum;
    private LocalDate checkIn;
    private LocalDate checkOut;

    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public Reservation(Integer roomNum, LocalDate checkIn, LocalDate checkOut) throws DomainException {
        if(checkOut.isBefore(checkIn)){
            throw new DomainException("Check-out date must be after check-in date");
        }
        
        this.roomNum = roomNum;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    
    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }
    
    
    public long duration(){
        Duration d = Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay());
        
        return d.toDays();
    }
    
    public void updateDates(LocalDate in, LocalDate out) throws DomainException{
        LocalDate now = LocalDate.now();
        
        if(in.isBefore(now) || out.isBefore(now)){
            throw new DomainException("Reservation dates for update must be future dates");
        }
        if(out.isBefore(in)){
            throw new DomainException("Check-out date must be after check-in date");
        }

        
        this.checkIn = in;
        this.checkOut = out;    
    }

    @Override
    public String toString() {
        return "Reservation: Room " + roomNum + ", Check-In: " + fmt.format(checkIn) + ", Check-Out: " + fmt.format(checkOut) + ", " + duration() + " Nights";
    }
}
