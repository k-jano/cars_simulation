package Models;

public class Car {
    public Position position = new Position(0,0);
    public Order order;
    public OrderStatus os = OrderStatus.NoClient;

}
