package reni.com.task11.decorator;

import reni.com.task11.entity.Recipe;

import java.time.Duration;

public class OneWeekExtendedRecipe extends ExtendedRecipe {

    public OneWeekExtendedRecipe(Recipe recipe) {
        super(recipe, Duration.ofDays(7));
    }
}
