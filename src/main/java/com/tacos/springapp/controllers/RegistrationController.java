package com.tacos.springapp.controllers;

import com.tacos.springapp.models.Role;
import com.tacos.springapp.models.User;
import com.tacos.springapp.repo.UserRepository;
import com.tacos.springapp.service.MailService;
import com.tacos.springapp.service.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.Collections;
import java.util.UUID;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/registration")
    public String addUser(User user, Model model){
        User userFromBd = userRepository.findByUsername(user.getUsername());
        if (userFromBd != null){
            model.addAttribute("check", "yes");
            return "/registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        if (!StringUtils.isEmpty(user.getEmail())){
            String message = String.format(
                    "Hi, %s ! Pls, click this link to finish registration: http://localhost:8080/activate/%s",
                    user.getUsername(),
                    user.getActivationCode()
            );
            mailService.send(user.getEmail(), "Activation code", message);
        }
        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code){
        boolean isActivated = userService.activateUser(code);
        if (isActivated){
            model.addAttribute("message", "User successfully activated");
        }
        else
            model.addAttribute("message", "Acivated code is not found!");
        return "login";
    }
}
