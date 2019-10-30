package reni.com.task11;

import reni.com.task11.decorator.ExtendedRecipe;
import reni.com.task11.decorator.OneWeekExtendedRecipe;
import reni.com.task11.entity.Medicament;
import reni.com.task11.entity.Recipe;
import reni.com.task11.entity.SimpleRecipe;
import reni.com.task11.service.PharmacyService;

import java.time.Duration;
import java.time.LocalDate;

public class RecipeExtensionApp {

    private PharmacyService pharmacyService;

    public RecipeExtensionApp(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    public static void main(String[] args) {
        new RecipeExtensionApp(new PharmacyService()).runDemoRecipeExtensionApp();
    }

    private void runDemoRecipeExtensionApp() {
        Recipe expiredRecipe = new SimpleRecipe("John Golt", 1, LocalDate.now().minusDays(3));
        System.out.println(expiredRecipe + "\n");

        Recipe extendedRecipe = new OneWeekExtendedRecipe(expiredRecipe);
        System.out.println(extendedRecipe);
        Medicament medicament = pharmacyService.buyMedicament(extendedRecipe, 1);
        System.out.println(String.format("You successfully bought %s%n", medicament));

        Recipe extendedRecipe2 = new ExtendedRecipe(extendedRecipe, Duration.ofDays(10));
        System.out.println(extendedRecipe2);
    }
}
