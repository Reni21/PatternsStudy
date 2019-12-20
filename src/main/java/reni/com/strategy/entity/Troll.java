package reni.com.strategy.entity;


import reni.com.strategy.strategy.MovementStrategy;

import java.util.List;

public class Troll extends Character {
    public Troll(String name, List<Class<? extends MovementStrategy>> validMovementStrategies) {
        super(name, validMovementStrategies);
    }
}
