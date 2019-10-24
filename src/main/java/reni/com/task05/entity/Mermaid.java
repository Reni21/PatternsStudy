package reni.com.task05.entity;


import reni.com.task05.strategy.MovementStrategy;

import java.util.List;

public class Mermaid extends Character {
    public Mermaid(String name, List<Class<? extends MovementStrategy>> validMovementStrategies) {
        super(name, validMovementStrategies);
    }

}
