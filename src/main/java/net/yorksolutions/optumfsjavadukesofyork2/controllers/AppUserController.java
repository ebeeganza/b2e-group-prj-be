package net.yorksolutions.optumfsjavadukesofyork2.controllers;

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

}
