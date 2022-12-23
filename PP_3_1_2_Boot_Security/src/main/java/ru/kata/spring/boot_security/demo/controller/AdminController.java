package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.repository.UserRepoImpl;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;



@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;
    private final UserRepoImpl userRepoImpl;

    @Autowired
    public AdminController(UserService userService, RoleService roleService,
                           UserRepoImpl userRepoImpl) {
        this.userService = userService;
        this.roleService = roleService;
        this.userRepoImpl = userRepoImpl;
    }

    @GetMapping
    private String getAllUsers() {
        return "admin";
    }

}
