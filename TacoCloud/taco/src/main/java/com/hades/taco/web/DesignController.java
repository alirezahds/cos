package com.hades.taco.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.hades.taco.Ingredient;
import com.hades.taco.Order;
import com.hades.taco.Taco;
import com.hades.taco.data.IngredientRepository;
import com.hades.taco.data.TacoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignController {

    IngredientRepository ingredientRepository;
    TacoRepository tacoRepository;

    @ModelAttribute("design")
    public Taco design() {
        return new Taco();
    }

    @ModelAttribute("order")
    public Order order() {
        return new Order();
    }

    @Autowired
    public DesignController(IngredientRepository ingredientRepository, TacoRepository tacoRepository) {
        this.ingredientRepository = ingredientRepository;
        this.tacoRepository = tacoRepository;
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(i -> ingredients.add(i));
        model.addAttribute("ingredients", ingredients);
        return "/design";
    }

    @PostMapping
    public String processDesignForm(@Valid @ModelAttribute("design") Taco design, Errors errors, Order order,
            Model model) {

        if (errors.hasErrors()) {
            List<Ingredient> ingredients = new ArrayList<>();
            ingredientRepository.findAll().forEach(i -> ingredients.add(i));
            model.addAttribute("ingredients", ingredients);
            return "design";
        }
        Taco saved = tacoRepository.save(design);
        order.addTaco(saved);

        return "redirect:/order";
    }
}
