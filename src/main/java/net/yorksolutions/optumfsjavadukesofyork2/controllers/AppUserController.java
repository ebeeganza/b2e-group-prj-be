package net.yorksolutions.optumfsjavadukesofyork2.controllers;

import net.yorksolutions.optumfsjavadukesofyork2.models.AppUser;
import net.yorksolutions.optumfsjavadukesofyork2.services.AppUserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
@RequestMapping("/users")
public class AppUserController {
    private AppUserService appUserService;
    @GetMapping
    public AppUser [] getAll() {
        return new AppUser[] {
                new AppUser(0L, "cust", "pass", 0)
                new AppUser(1L, "shop", "pass", 1)
                new AppUser(2L, "admin", "pass", 3)

        };
    }

}
