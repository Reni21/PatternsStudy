package reni.com.task05.entity;


import reni.com.task05.strategy.MovementStrategy;

import java.util.List;

public class Knight extends Character {

    public Knight(String name, List<Class<? extends MovementStrategy>> validMovementStrategies) {
        super(name, validMovementStrategies);
    }

}
