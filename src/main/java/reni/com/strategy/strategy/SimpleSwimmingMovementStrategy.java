package reni.com.strategy.strategy;

public class SimpleSwimmingMovementStrategy implements MovementStrategy {
    @Override
    public void move() {
        System.out.println("start simple swim...");
    }

    @Override
    public String getSimpleName() {
        return "Simple Swim";
    }
}
