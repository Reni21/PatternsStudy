package reni.com.task05.service;

import reni.com.task05.entity.Character;
import reni.com.task05.exception.IllegalStrategyException;
import reni.com.task05.strategy.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharacterService {
    public static final Map<Class, MovementStrategy> MOVEMENT_STRATEGIES;

    public void moveCharacter(Character character, Class<? extends MovementStrategy> strategyClazz) throws IllegalStrategyException {
        List<Class<? extends MovementStrategy>> validStrategies = character.getValidMovementStrategies();
        MovementStrategy strategy = MOVEMENT_STRATEGIES.get(strategyClazz);
        validateStrategy(strategy, strategyClazz);

        if(validStrategies.contains(strategyClazz)) {
            character.move(strategy);
        } else {
            throw new IllegalStrategyException(strategy);
        }
    }

    private void validateStrategy(MovementStrategy strategy, Class strategyClazz) {
        if (strategy == null) {
            throw new IllegalArgumentException("MOVEMENT_STRATEGIES map does not contain strategy class=" + strategyClazz.getName());
        }
    }

    static {
        MOVEMENT_STRATEGIES = Stream.of(
                new MagicFlyingMovementStrategy(),
                new MagicSwimmingMovementStrategy(),
                new RunMovementStrategy(),
                new SimpleWalkingMovementStrategy(),
                new SimpleSwimmingMovementStrategy(),
                new ShipSwimmingMovementStrategy(),
                new HorseRidingMovementStrategy(),
                new FlyingOnWingsMovementStrategy()
        ).collect(Collectors.toMap(MovementStrategy::getClass, Function.identity()));
    }

}
