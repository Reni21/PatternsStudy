package reni.com.task05.exception;

import reni.com.task05.strategy.MovementStrategy;

public class IllegalStrategyException extends Exception {
    public IllegalStrategyException(MovementStrategy movementStrategy) {
        super("Unsupported movement strategy: " + movementStrategy.getClass().getSimpleName());
    }
}
