package reni.com.strategy.entity;


import reni.com.strategy.strategy.MovementStrategy;

import java.util.List;

public class Knight extends Character {

    public Knight(String name, List<Class<? extends MovementStrategy>> validMovementStrategies) {
        super(name, validMovementStrategies);
    }

}
