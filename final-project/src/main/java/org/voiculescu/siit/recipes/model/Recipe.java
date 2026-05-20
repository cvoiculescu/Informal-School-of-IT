package org.voiculescu.siit.recipes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;
import org.voiculescu.siit.recipes.util.RecipeSanitizer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

import static java.util.Base64.getEncoder;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class Recipe {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "recipe_seq", sequenceName = "recipe_seq", allocationSize = 1)
    private Long id;
    @Size(min = 6, message = "minimum 6 characters")
    private String name;
    @Size(min = 20, message = "minimum 20 characters")
    private String shortDescription;
    @Size(min = 20, message = "minimum 20 characters")
    @Column(length = 3000)
    private String ingredients;
    @Size(min = 20, message = "minimum 20 characters")
    @Column(length = 3000)
    private String directions;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @NotEmpty(message = "an image should be provided")
    @Lob
    byte[] image;
    @Enumerated(EnumType.STRING)
    private RecipeCategory recipeCategory;
    @CreationTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate created;
    @UpdateTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate lastModified;

    public Recipe setName(String name) {
        this.name = RecipeSanitizer.sanitizePlainText(name);
        return this;
    }

    public Recipe setShortDescription(String shortDescription) {
        this.shortDescription = RecipeSanitizer.sanitizePlainText(shortDescription);
        return this;
    }

    public Recipe setIngredients(String ingredients) {
        this.ingredients = RecipeSanitizer.sanitizePlainText(ingredients);
        return this;
    }

    public Recipe setDirections(String directions) {
        this.directions = RecipeSanitizer.sanitizePlainText(directions);
        return this;
    }


    public String getImage() {
        if (image != null) {
            return getEncoder().encodeToString(image);
        }
        return null;
    }

    public byte[] getImageBytes() {
        return image == null ? null : image.clone();
    }

    public Recipe setImageBytes(byte[] image) {
        this.image = image == null ? null : image.clone();
        return this;
    }

    public Recipe setImage(MultipartFile image) {
        try {
            this.image = image.getBytes();
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
        }
        return this;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy proxy
                ? proxy.getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy proxy
                ? proxy.getHibernateLazyInitializer().getPersistentClass()
                : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Recipe recipe = (Recipe) o;
        return getId() != null && Objects.equals(getId(), recipe.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy proxy
                ? proxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
                : getClass().hashCode();
    }
}
