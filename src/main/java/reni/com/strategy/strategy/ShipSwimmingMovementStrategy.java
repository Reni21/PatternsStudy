package reni.com.strategy.strategy;

public class ShipSwimmingMovementStrategy implements MovementStrategy {
    @Override
    public void move() {
        System.out.println("start swim with ship...");
    }

    @Override
    public String getSimpleName() {
        return "Ship Swimming";
    }
}
