package com.codegym.casestudy4.controller;

import com.codegym.casestudy4.dto.ProductDto;
import com.codegym.casestudy4.dto.UserDto;
import com.codegym.casestudy4.dto.UserLoginDto;
import com.codegym.casestudy4.entity.Product;
import com.codegym.casestudy4.entity.User;
import com.codegym.casestudy4.mapper.ProductMapper;
import com.codegym.casestudy4.service.ProductService;
import com.codegym.casestudy4.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model) {
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
            model.addAttribute("hasError", true);
        }

        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "redirect:/register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

    @PostMapping("/login/save")
    public String login(@Valid @ModelAttribute("user") UserLoginDto userLoginDto, BindingResult result, Model model) {
        User existingUser = userService.findUserByUsername(userLoginDto.getUsername());
        if (!userService.isPasswordCorrect(userLoginDto.getPassword(), existingUser.getPassword())) {
            result.rejectValue("email", null,
                    "This account does not exist");
            model.addAttribute("hasError", true);
        } else {
            if (!existingUser.getUsername().equals(userLoginDto.getUsername())) {
                result.rejectValue("username", null,
                        "This account does not exist");
                model.addAttribute("hasError", true);
            }
        }
        if (result.hasErrors()) {
            return "redirect:/login";
        }
        //tạo cart check cart
        return "redirect:/index/" + existingUser.getId();
    }

    //    @GetMapping("/users")
//    public String users(Model model){
//        List<UserDto> users = userService.findAllUser();
//        model.addAttribute("users", users);
//        return "users";
//    }
    @GetMapping("/login")
    public String login(Model model) {
        UserLoginDto userLoginDto = new UserLoginDto();
        model.addAttribute("user", userLoginDto);
        return "login";
    }
}
