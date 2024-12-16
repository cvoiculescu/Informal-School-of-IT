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
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public String getIngredientsList() {
        return ingredients.replaceAll(System.lineSeparator(),"'&lt;br /&gt;");
    }

    public String getDirectionsList() {
        return directions.replaceAll(System.lineSeparator(),"'&lt;br /&gt;");
    }

    public String getImage() {
        if (image != null) {
            return getEncoder().encodeToString(image);
        }
        return null;
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
