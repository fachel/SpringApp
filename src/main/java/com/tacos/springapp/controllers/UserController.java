package com.tacos.springapp.controllers;

import com.tacos.springapp.models.Role;
import com.tacos.springapp.models.User;
import com.tacos.springapp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping
    public String userList(Model model){
        model.addAttribute("userList", userRepo.findAll());
        return "userList";
    }

    @GetMapping("/{user}")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping
    public String userSave(@RequestParam("userId") User user,
                           @RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("phone_number") String phone_number,
                           @RequestParam Map<String, String> form){
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone_number(phone_number);

        user.getRoles().clear();

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name).collect(Collectors.toSet());

        for (String key: form.keySet()){
            if (roles.contains(key))
                user.getRoles().add(Role.valueOf(key));
        }

        userRepo.save(user);
        return "redirect:/user";
    }
}
