package reni.com.task05.entity;


import reni.com.task05.strategy.MovementStrategy;

import java.util.List;

public class Troll extends Character {
    public Troll(String name, List<Class<? extends MovementStrategy>> validMovementStrategies) {
        super(name, validMovementStrategies);
    }
}
