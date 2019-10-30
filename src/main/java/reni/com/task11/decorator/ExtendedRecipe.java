package reni.com.task11.decorator;

import reni.com.task11.entity.Recipe;

import java.time.Duration;
import java.time.LocalDate;

public class ExtendedRecipe extends RecipeDecorator {

    private Duration extensionPeriod;

    public ExtendedRecipe(Recipe recipe, Duration extensionPeriod) {
        super(recipe);
        this.extensionPeriod = extensionPeriod;
    }

    @Override
    public LocalDate expiredAt() {
        return super.recipe.expiredAt().plusDays(extensionPeriod.toDays());
    }


}
