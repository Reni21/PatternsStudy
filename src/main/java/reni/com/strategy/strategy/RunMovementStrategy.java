package reni.com.strategy.strategy;

public class RunMovementStrategy implements MovementStrategy {
    @Override
    public void move() {
        System.out.println("start run...");
    }

    @Override
    public String getSimpleName() {
        return "Run";
    }
}
