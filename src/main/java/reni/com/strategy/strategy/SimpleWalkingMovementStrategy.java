package reni.com.strategy.strategy;

public class SimpleWalkingMovementStrategy implements MovementStrategy {
    @Override
    public void move() {
        System.out.println("start simple walk...");
    }

    @Override
    public String getSimpleName() {
        return "Simple Walking";
    }
}
