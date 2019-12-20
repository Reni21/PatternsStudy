package reni.com.strategy.strategy;

public class MagicSwimmingMovementStrategy implements MovementStrategy {
    @Override
    public void move() {
        System.out.println("start swim with magic...");
    }

    @Override
    public String getSimpleName() {
        return "Magic Swimming";
    }
}
