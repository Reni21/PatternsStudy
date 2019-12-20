package reni.com.decorator.decorator;

import reni.com.decorator.entity.Recipe;

public abstract class RecipeDecorator implements Recipe {
    protected Recipe recipe;

    public RecipeDecorator(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public String getDoctorName() {
        return recipe.getDoctorName();
    }

    @Override
    public Integer getMedicineId() {
        return recipe.getMedicineId();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "doctorName='" + recipe.getDoctorName() + '\'' +
                ", medicineId=" + recipe.getMedicineId() +
                ", expiredAt=" + expiredAt() +
                '}';

    }
}
