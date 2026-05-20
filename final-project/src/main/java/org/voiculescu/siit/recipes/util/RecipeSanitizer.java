package org.voiculescu.siit.recipes.util;

import org.voiculescu.siit.recipes.model.Recipe;

import java.util.regex.Pattern;

public final class RecipeSanitizer {

    private static final Pattern SCRIPT_AND_STYLE_BLOCKS = Pattern.compile("(?is)<(script|style)[^>]*>.*?</\\1>");
    private static final Pattern HTML_TAGS = Pattern.compile("(?is)<[^>]+>");

    private RecipeSanitizer() {
    }

    public static String sanitizePlainText(String value) {
        if (value == null) {
            return null;
        }
        String withoutScripts = SCRIPT_AND_STYLE_BLOCKS.matcher(value).replaceAll("");
        return HTML_TAGS.matcher(withoutScripts).replaceAll("");
    }

    public static Recipe sanitizeForView(Recipe recipe) {
        if (recipe == null) {
            return null;
        }

        return new Recipe()
                .setId(recipe.getId())
                .setName(recipe.getName())
                .setShortDescription(recipe.getShortDescription())
                .setIngredients(recipe.getIngredients())
                .setDirections(recipe.getDirections())
                .setRecipeCategory(recipe.getRecipeCategory())
                .setCreated(recipe.getCreated())
                .setLastModified(recipe.getLastModified())
                .setImageBytes(recipe.getImageBytes());
    }
}

