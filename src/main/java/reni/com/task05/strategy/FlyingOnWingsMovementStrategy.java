package reni.com.task05.strategy;

public class FlyingOnWingsMovementStrategy implements MovementStrategy {
    @Override
    public void move() {
        System.out.println("start fly with wings...");
    }

    @Override
    public String getSimpleName() {
        return "Flying On Wings";
    }
}
