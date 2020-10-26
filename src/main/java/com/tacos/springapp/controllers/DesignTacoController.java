package com.tacos.springapp.controllers;

import com.tacos.springapp.models.Ingredient;
import com.tacos.springapp.models.Taco;
import com.tacos.springapp.repo.IngredientRepository;
import com.tacos.springapp.repo.TakoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/design")
public class DesignTacoController {
//    RestTemplate rest = new RestTemplate();

    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private TakoRepository takoRepository;

    @GetMapping
    public String showDesignForm(Model model) {
        Iterable<Ingredient> ingr = ingredientRepository.findAll();
        String[] types = {"WRAP", "PROTEIN", "VEGGIES", "CHEESE", "SAUCE"};
        for (String type : types) {
            model.addAttribute(type.toLowerCase(), filterByType(ingr, type));
        }
        model.addAttribute("design", new Taco());
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors) {
        if (errors.hasErrors()) {
            System.out.println("error");
            return "design";
        }
        System.out.println("yes");
        // Save the taco design…
        // We'll do this in chapter 3
        takoRepository.save(design);
        System.out.println("Processing design: " + design);
//        log.info("Processing design: " + design);
        return "redirect:/orders/current"; //перенапрявляет на контроллер orders/current
    }

    public List filterByType(Iterable<Ingredient> ingredients, String type) {
        List<Ingredient> list = new ArrayList<>();
        for (Ingredient ingredient : ingredients){
            if (ingredient.getType().equals(type))
                list.add(ingredient);
        }
        return list;
    }

    @GetMapping("/{id}")
    public Taco tacoById(@PathVariable("id") Long id) {
        Optional<Taco> optTaco = takoRepository.findById(id);
        if (optTaco.isPresent()) {
            return optTaco.get();
        }
        return null;
    }

//    @GetMapping("/{id}")
//    public Mono<Taco> tacoById(@PathVariable("id") Long id) {
//        return tacoRepo.findById(id);
//    }


}
