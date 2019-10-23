package reni.com.task05.entity;

import reni.com.task05.exception.IllegalStrategyException;
import reni.com.task05.strategy.MovementStrategy;

import java.util.List;

public abstract class Character {
    private List<Class> validMovementStrategies;
    private String name;

    public Character(String name, List<Class> validMovementStrategies) {
        this.name = name;
        this.validMovementStrategies = validMovementStrategies;
    }

    public void move(MovementStrategy movementStrategy) throws IllegalStrategyException {
        Class clazz = movementStrategy.getClass();
        if(!validMovementStrategies.contains(clazz)) {
            throw new IllegalStrategyException(movementStrategy);
        }
        movementStrategy.move();
    }

    public List<Class> getValidMovementStrategies() {
        return validMovementStrategies;
    }

    public String getName() {
        return name;
    }

}
