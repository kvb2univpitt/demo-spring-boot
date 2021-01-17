package com.github.kvb2univpitt.demo.secured.webapp.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * Dec 26, 2020 9:28:19 PM
 *
 * @author Kevin V. Bui (kvb2univpitt@gmail.com)
 */
@Controller
public class ApplicationController {

    @GetMapping("/")
    public String showIndexPage() {
        return "redirect:/secured/home";
    }

    @GetMapping("/secured/home")
    public String showHomePage() {
        return "secured/home";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

}
