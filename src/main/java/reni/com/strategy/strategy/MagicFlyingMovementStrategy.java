package reni.com.strategy.strategy;

public class MagicFlyingMovementStrategy implements MovementStrategy {
    @Override
    public void move() {
        System.out.println("start fly with magic...");
    }

    @Override
    public String getSimpleName() {
        return "Magic Flying";
    }
}
