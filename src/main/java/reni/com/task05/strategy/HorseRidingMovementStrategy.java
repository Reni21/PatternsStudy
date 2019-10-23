package reni.com.task05.strategy;

public class HorseRidingMovementStrategy implements MovementStrategy {
    @Override
    public void move() {
        System.out.println("start ride a horse...");
    }

    @Override
    public String getSimpleName() {
        return "Horse Riding";
    }
}
