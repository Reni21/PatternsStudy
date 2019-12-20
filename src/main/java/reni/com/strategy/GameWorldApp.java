package reni.com.strategy;

import reni.com.strategy.entity.Character;
import reni.com.strategy.exception.IllegalStrategyException;
import reni.com.strategy.service.CharacterService;
import reni.com.strategy.strategy.*;
import reni.com.strategy.util.InitializerUtil;

import java.util.*;

public class GameWorldApp {
    private CharacterService characterService;

    private GameWorldApp(CharacterService characterService) {
        this.characterService = characterService;
    }

    public static void main(String[] args) {
        List<Character> characters = InitializerUtil.initCharacters();
        try (Scanner scanner = new Scanner(System.in)) {
            new GameWorldApp(new CharacterService()).runGameWorldApp(characters, scanner);
        }
    }

    private void runGameWorldApp(List<Character> characters, Scanner scanner) {
        System.out.println("Choose character:");
        characters.forEach(character -> {
                    int index = characters.indexOf(character);
                    String characterClazz = character.getClass().getSimpleName();
                    System.out.format("%d - %s %s%n", index, characterClazz, character.getName());
                }
        );

        while (true) {
            try {
                getUserInput(characters, scanner);
            } catch (IllegalArgumentException | UnsupportedOperationException e) {
                System.out.println(e.getMessage());
            } catch (IllegalStrategyException e) {
                e.printStackTrace();
                System.exit(-1);
            }
            System.out.println("\nChoose character:");
        }
    }

    private void getUserInput(List<Character> characters, Scanner scanner) throws IllegalStrategyException {
        int inputCharacterNumber = -1;
        try {
            inputCharacterNumber = Integer.parseInt(scanner.nextLine());
            validateInputByRange(inputCharacterNumber, characters.size(), "characters");
            Character character = characters.get(inputCharacterNumber);
            List<Class<? extends MovementStrategy>> validStrategies = character.getValidMovementStrategies();
            validateCharacterStrategies(validStrategies);

            Class<? extends MovementStrategy> strategyClazz;
            if (validStrategies.size() == 1) {
                strategyClazz = validStrategies.get(0);
            } else {
                int inputStrategyNumber = getUserInputStrategyNum(validStrategies, scanner);
                strategyClazz = validStrategies.get(inputStrategyNumber);
            }
            characterService.moveCharacter(character, strategyClazz);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input format. Use only numbers for input.");
        }
    }

    private int getUserInputStrategyNum(List<Class<? extends MovementStrategy>> validStrategies, Scanner scanner) {
        int numberOfMovementStrategies = validStrategies.size();
        System.out.println("Choose number of character movement strategy:");
        validStrategies.forEach(clazz -> {
                    int index = validStrategies.indexOf(clazz);
                    String strategyName = CharacterService.MOVEMENT_STRATEGIES.get(clazz).getSimpleName();
                    System.out.format("%d - %s%n", index, strategyName);
                }
        );

        int strategyNum = Integer.parseInt(scanner.nextLine());
        validateInputByRange(strategyNum, numberOfMovementStrategies, "strategy");
        return strategyNum;
    }

    private void validateInputByRange(int inputNumber, int requiredRange, String objectName){
        if (inputNumber >= requiredRange || inputNumber < 0) {
            throw new IllegalArgumentException(String.format("Missing %s with such number \"%s\"%n",objectName, inputNumber));
        }

    }

    private void validateCharacterStrategies(List<Class<? extends MovementStrategy>> validStrategies) {
        if (validStrategies == null || validStrategies.isEmpty()) {
            throw new UnsupportedOperationException("This character can not move.");
        }
    }

}
