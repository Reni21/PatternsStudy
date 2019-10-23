package reni.com.task05.service;

import reni.com.task05.entity.Character;
import reni.com.task05.exception.IllegalStrategyException;
import reni.com.task05.strategy.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharacterService {
    private static final Map<Class, MovementStrategy> MOVEMENT_STRATEGIES;

    public void moveCharacter(Character character, Scanner scanner) throws IllegalStrategyException {
        List<Class> validStrategies = character.getValidMovementStrategies();
        int input = -1;

        try {
            int numberOfMovementStrategies = validStrategies.size();
            if (numberOfMovementStrategies == 1) {
                MovementStrategy strategy = MOVEMENT_STRATEGIES.get(validStrategies.get(0));
                character.move(strategy);
                return;
            }

            input = getUserInputStrategyNum(validStrategies, scanner);
            Class clazz = validStrategies.get(input);
            MovementStrategy strategy = MOVEMENT_STRATEGIES.get(clazz);
            validateStrategy(strategy, clazz);
            character.move(MOVEMENT_STRATEGIES.get(clazz));

        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(String.format("Missing strategy with such number \"%s\"", input));
        }
    }

    private void validateStrategy(MovementStrategy strategy, Class clazz) {
        if (strategy == null) {
            throw new IllegalArgumentException("MOVEMENT_STRATEGIES map does not contain strategy class=" + clazz.getName());
        }
    }

    private int getUserInputStrategyNum(List<Class> validStrategies, Scanner scanner) {
        int numberOfMovementStrategies = validStrategies.size();
        System.out.println("Choose number of character movement strategy:");
        for (int i = 0; i < numberOfMovementStrategies; i++) {
            MovementStrategy strategy = MOVEMENT_STRATEGIES.get(validStrategies.get(i));
            System.out.println(i + " - " + strategy.getSimpleName());
        }
        int strategyNum = Integer.parseInt(scanner.nextLine());
        if (strategyNum >= numberOfMovementStrategies || strategyNum < 0) {
            throw new IllegalArgumentException(String.format("Missing strategy with such number \"%s\"%n", strategyNum));
        }
        return strategyNum;
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
