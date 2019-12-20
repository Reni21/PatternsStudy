package reni.com.strategy.util;

import reni.com.strategy.entity.*;
import reni.com.strategy.entity.Character;
import reni.com.strategy.strategy.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InitializerUtil {
    public static List<Character> initCharacters() {
        List<Character> characters = new LinkedList<>();
        characters.add(new Vampire("Dracula",Arrays.asList(
                RunMovementStrategy.class,
                FlyingOnWingsMovementStrategy.class,
                SimpleWalkingMovementStrategy.class)));
        characters.add(new Wizard("Volan De Mort", Arrays.asList(
                RunMovementStrategy.class,
                MagicSwimmingMovementStrategy.class,
                MagicFlyingMovementStrategy.class,
                SimpleWalkingMovementStrategy.class,
                HorseRidingMovementStrategy.class)));
        characters.add(new Mermaid("Ursula", Arrays.asList(
                SimpleSwimmingMovementStrategy.class)));
        characters.add(new Troll("Butcher", Arrays.asList(
                RunMovementStrategy.class,
                SimpleWalkingMovementStrategy.class)));
        characters.add(new Knight("Artur", Arrays.asList(
                RunMovementStrategy.class,
                SimpleSwimmingMovementStrategy.class,
                SimpleWalkingMovementStrategy.class,
                HorseRidingMovementStrategy.class)));
        return characters;
    }
}
