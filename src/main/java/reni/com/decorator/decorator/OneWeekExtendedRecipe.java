package reni.com.decorator.decorator;

import reni.com.decorator.entity.Recipe;

import java.time.Duration;

public class OneWeekExtendedRecipe extends ExtendedRecipe {

    public OneWeekExtendedRecipe(Recipe recipe) {
        super(recipe, Duration.ofDays(7));
    }
}
