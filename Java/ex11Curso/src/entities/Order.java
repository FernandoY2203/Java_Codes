
package entities;

import entities.enums.OrderStatus;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private LocalDateTime moment;
    private OrderStatus status;
    
    private Client client;
    private List<OrderItem> items = new ArrayList<>();

    
    public Order(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    
    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getOrders() {
        return items;
    }
    
    
    public void addItem(OrderItem item){
        items.add(item);
    }
    
    public void removeItem(OrderItem item){
        items.remove(item);
    }
    
    public double total(){
        double aux = 0;
        
        for (OrderItem i : items) {
            aux += i.subTotal();
        }
        
        return aux;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Order moment: " + fmt1.format(moment) + "\n");
        sb.append("Order Status: " + status + "\n");
        sb.append("Client: " + client.getName() + " (" + fmt2.format(client.getBirthDate()) + ") - " + client.getEmail() + "\n");
        for (OrderItem i : items) {
            sb.append(i.getProduct().getName() + ", $" + String.format("%.2f",i.getProduct().getPrice())+ ", Quantity: " + i.getQuantity() + ", Subtotal: $" + String.format("%.2f", i.subTotal()) + "\n");
        }
        sb.append("Total price: $" + String.format("%.2f", total()));
        
        return sb.toString();
    }
}
