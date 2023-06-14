
package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product{
    
    private LocalDate date;
    

    public UsedProduct(LocalDate date, String name, Double price) {
        super(name, price);
        this.date = date;
    }

    
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String priceTag() {
        return getName() + " (used) $" + String.format("%.2f", getPrice()) + " (Manufactured date: " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ")";
    }
}
