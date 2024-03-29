package reni.com.strategy.entity;

import reni.com.strategy.exception.IllegalStrategyException;
import reni.com.strategy.strategy.MovementStrategy;

import java.util.List;

public abstract class Character {
    private List<Class<? extends MovementStrategy>> validMovementStrategies;
    private String name;

    Character(String name, List<Class<? extends MovementStrategy>> validMovementStrategies) {
        this.name = name;
        this.validMovementStrategies = validMovementStrategies;
    }

    public void move(MovementStrategy movementStrategy) throws IllegalStrategyException {
        Class clazz = movementStrategy.getClass();
        if (!validMovementStrategies.contains(clazz)) {
            throw new IllegalStrategyException(movementStrategy);
        }
        System.out.print(name + " ");
        movementStrategy.move();
    }

    public List<Class<? extends MovementStrategy>> getValidMovementStrategies() {
        return validMovementStrategies;
    }

    public String getName() {
        return name;
    }

}
