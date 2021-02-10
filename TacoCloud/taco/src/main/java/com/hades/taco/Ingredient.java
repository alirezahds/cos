package com.hades.taco;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class Ingredient {

    @Id
    private final String id;

    private final String name;

    private final Type type;

    private String typeName;

    public Ingredient(String id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.typeName = type.toString().toLowerCase();
    }

    enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}