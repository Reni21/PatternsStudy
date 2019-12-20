package reni.com.strategy.exception;

import reni.com.strategy.strategy.MovementStrategy;

public class IllegalStrategyException extends Exception {
    public IllegalStrategyException(MovementStrategy movementStrategy) {
        super("Unsupported movement strategy: " + movementStrategy.getClass().getSimpleName());
    }
}
