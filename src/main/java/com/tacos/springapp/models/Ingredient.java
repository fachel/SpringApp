package com.tacos.springapp.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;



//  таблицы должны иметь конструктор без аргументов,
// Lombok-а делает это за нас однако, вы не хотите, чтобы имелась возможность использовать его, поэтому сделайте его private,
// установив атрибут доступа AccessLevel.PRIVATE. И поскольку есть final свойства, которые должны быть установлены,
// вы также устанавливаете трибут force в true, что приводит к тому, что конструктор, сгенерированный Lombok-ом,
// устанавливает их в null.


@Data //автоматически создает гетеры и сеттеры констуктор и тд,но мы их не видим
@RequiredArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@Entity
public class Ingredient {
    @Id
    private final String id;
    private final String name;
    private final String type;

//    public static enum Type {
//        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
//    }
}