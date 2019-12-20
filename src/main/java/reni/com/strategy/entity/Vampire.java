package reni.com.strategy.entity;


import reni.com.strategy.strategy.MovementStrategy;

import java.util.List;

public class Vampire extends Character {
    public Vampire(String name, List<Class<? extends MovementStrategy>> validMovementStrategies) {
        super(name, validMovementStrategies);
    }

}
