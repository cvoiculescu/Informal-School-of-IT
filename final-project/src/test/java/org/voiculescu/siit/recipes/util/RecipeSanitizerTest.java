package org.voiculescu.siit.recipes.util;

import org.junit.jupiter.api.Test;
import org.voiculescu.siit.recipes.model.Recipe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class RecipeSanitizerTest {

    @Test
    void sanitizePlainTextRemovesHtmlAndScripts() {
        assertEquals("Soup\n", RecipeSanitizer.sanitizePlainText("<b>Soup</b>\n<script>alert(1)</script>"));
    }

    @Test
    void sanitizeForViewReturnsSanitizedCopy() {
        Recipe recipe = new Recipe()
                .setId(1L)
                .setName("<b>Tomato Soup</b>")
                .setShortDescription("<i>Comfort food</i>")
                .setIngredients("<script>alert(1)</script>Tomatoes")
                .setDirections("<img src=x onerror=alert(1)>Boil")
                .setImageBytes(new byte[]{1, 2, 3});

        Recipe sanitized = RecipeSanitizer.sanitizeForView(recipe);

        assertNotSame(recipe, sanitized);
        assertEquals("Tomato Soup", sanitized.getName());
        assertEquals("Comfort food", sanitized.getShortDescription());
        assertEquals("Tomatoes", sanitized.getIngredients());
        assertEquals("Boil", sanitized.getDirections());
        assertEquals("AQID", sanitized.getImage());
    }
}

