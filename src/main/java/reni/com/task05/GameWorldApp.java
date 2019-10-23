package reni.com.task05;

import reni.com.task05.entity.*;
import reni.com.task05.entity.Character;
import reni.com.task05.exception.IllegalStrategyException;
import reni.com.task05.service.CharacterService;
import reni.com.task05.strategy.*;

import java.util.*;

public class GameWorldApp {
    private CharacterService characterService;

    public GameWorldApp(CharacterService characterService) {
        this.characterService = characterService;
    }

    public static void main(String[] args) {
        List<Character> characters = initCharacters();
        try (Scanner scanner = new Scanner(System.in)) {
            new GameWorldApp(new CharacterService()).runGameWorldApp(characters, scanner);
        }
    }

    private void runGameWorldApp(List<Character> characters, Scanner scanner) {
        printCharactersList(characters);

        int input = -1;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                characterService.moveCharacter(characters.get(input), scanner);
                System.out.println("\nChoose character:");

            } catch (IndexOutOfBoundsException e) {
                System.out.format("Missing character with such number \"%s\"%n", input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input format. Use only numbers for input.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (IllegalStrategyException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }

    private void printCharactersList(List<Character> characters) {
        System.out.println("Choose character:");
        int numberOfCharacters = characters.size();
        for (int i = 0; i < numberOfCharacters; i++) {
            Character character = characters.get(i);
            System.out.println(i + " - " + character.getClass().getSimpleName() + " " + character.getName());
        }
    }

    public static List<Character> initCharacters() {
        List<Character> characters = new LinkedList<>();
        characters.add(new Vampire("Dracula", Gender.MALE, Arrays.asList(
                RunMovementStrategy.class,
                FlyingOnWingsMovementStrategy.class,
                SimpleWalkingMovementStrategy.class)));
        characters.add(new Wizard("Volan De Mort", Gender.MALE, Arrays.asList(
                RunMovementStrategy.class,
                MagicSwimmingMovementStrategy.class,
                MagicFlyingMovementStrategy.class,
                SimpleWalkingMovementStrategy.class,
                HorseRidingMovementStrategy.class)));
        characters.add(new Mermaid("Ursula", Gender.FEMALE, Arrays.asList(
                SimpleSwimmingMovementStrategy.class)));
        characters.add(new Troll("Butcher", Gender.BIGENDER, Arrays.asList(
                RunMovementStrategy.class,
                SimpleWalkingMovementStrategy.class)));
        characters.add(new Knight("Artur", Gender.MALE, Arrays.asList(
                RunMovementStrategy.class,
                SimpleSwimmingMovementStrategy.class,
                SimpleWalkingMovementStrategy.class,
                HorseRidingMovementStrategy.class)));
        return characters;
    }


}
