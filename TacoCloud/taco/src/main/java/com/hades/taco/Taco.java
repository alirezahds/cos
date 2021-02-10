package com.hades.taco;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 5, message = "Name should be atleast 5 characters!")
    private String name;
    @NotEmpty(message = "Choose at least one ingredient!")
    @ManyToMany
    private List<Ingredient> ingredients = new ArrayList<>();

}
