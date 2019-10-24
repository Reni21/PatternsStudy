package reni.com.task05.entity;


import reni.com.task05.strategy.MovementStrategy;

import java.util.List;

public class Vampire extends Character {
    public Vampire(String name, List<Class<? extends MovementStrategy>> validMovementStrategies) {
        super(name, validMovementStrategies);
    }

}
