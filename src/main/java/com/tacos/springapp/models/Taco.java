package com.tacos.springapp.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Taco {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) //автоинкремент (нач с 1 и далее +1)
    private Long id;

    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;
    private Date createdAt;

    @ManyToMany(targetEntity=Ingredient.class)//связть многие ко многим (taco и Ingredient)
    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

    @PrePersist//указывает, что метод должен быть вызван до того, как объект Taco будет вставлен (сохранен) в базу данных.
    void createdAt() {
        this.createdAt = new Date();
    }
}
