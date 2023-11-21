
package application;

import entities.Order;
import entities.enums.OrderStatus;
import java.time.LocalDateTime;

public class Program {
    public static void main(String[] args) {
        OrderStatus os1 = OrderStatus.valueOf("ENTREGUE");
        OrderStatus os2 = OrderStatus.ENVIADO;
        
        Order pedido = new Order(1080, LocalDateTime.now(), OrderStatus.PAGAMENTO_PENDENTE);
        
        System.out.println(pedido);
        System.out.println(os1);
        System.out.println(os2);
    }
}
