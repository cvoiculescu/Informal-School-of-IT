package org.voiculescu.siit.recipes.model;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum RecipeCategory {

    SOUP("Soup", "soup"),
    MAIN_DISH("Main Dish", "main-dish"),
    SALAD("Salad", "salad"),
    DESSERT("Dessert", "dessert"),
    MISCELLANEOUS("Miscellaneous", "misc");

    private final String displayValue;
    private final String path;

    RecipeCategory(String displayValue, String path) {
        this.displayValue = displayValue;
        this.path = path;
    }

    public static RecipeCategory getRecipeCategoryByPath(String temp) {
        return Arrays.stream(RecipeCategory.values())
                .filter(category -> category.getPath().equalsIgnoreCase(temp))
                .findFirst().orElse(null);
    }
}
