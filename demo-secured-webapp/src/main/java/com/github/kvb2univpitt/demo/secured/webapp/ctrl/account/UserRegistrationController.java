package com.github.kvb2univpitt.demo.secured.webapp.ctrl.account;

import com.github.kvb2univpitt.demo.secured.webapp.db.service.AppUserService;
import com.github.kvb2univpitt.demo.secured.webapp.dto.account.UserRegistrationForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * Dec 30, 2020 3:51:16 AM
 *
 * @author Kevin V. Bui (kvb2univpitt@gmail.com)
 */
@Controller
@RequestMapping(value = "/registration")
public class UserRegistrationController {

    private static final String REGISTRATION_ERROR = "Registration Error!";
    private static final String[] REGISTRATION_SUCCESS = {"Registration Success!", "Please enter your credentials to log in."};
    private static final String[] REGISTRATION_FAILED = {"Registration Failed!", "Unable to register new user at this time."};
    private static final String ACCOUNT_EXISTED = "Account already existed.";
    private static final String CONFIRM_PASSWORD_NOT_MATCH = "Confirm password not match.";

    private final AppUserService appUserService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserRegistrationController(AppUserService appUserService, BCryptPasswordEncoder passwordEncoder) {
        this.appUserService = appUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public String processUserRegistration(
            @Valid @ModelAttribute("userRegistrationForm") final UserRegistrationForm userRegistrationForm,
            final BindingResult bindingResult,
            final RedirectAttributes redirAttrs,
            final Model model,
            final HttpServletRequest req,
            final HttpServletResponse res) {

        if (!isValid(userRegistrationForm, bindingResult, redirAttrs)) {
            return "redirect:/registration";
        }

        String username = userRegistrationForm.getUsername();
        String password = userRegistrationForm.getPassword();
        String firstName = userRegistrationForm.getFirstName();
        String lastName = userRegistrationForm.getLastName();

        try {
            appUserService.addNewUser(username, passwordEncoder.encode(password), firstName, lastName);
        } catch (Exception exception) {
            redirAttrs.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationForm", bindingResult);
            redirAttrs.addFlashAttribute("userRegistrationForm", userRegistrationForm);
            redirAttrs.addFlashAttribute("errorMsg", REGISTRATION_FAILED);

            return "redirect:/registration";
        }

        redirAttrs.addFlashAttribute("successMsg", REGISTRATION_SUCCESS);

        return "redirect:/login";
    }

    @GetMapping
    public String showUserRegistrationPage(final SessionStatus sessionStatus, final Model model) {
        if (!model.containsAttribute("userRegistrationForm")) {
            model.addAttribute("userRegistrationForm", new UserRegistrationForm());
        }

        return "account/user_registration";
    }

    private boolean isValid(UserRegistrationForm form, BindingResult bindingResult, RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            redirAttrs.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationForm", bindingResult);
            redirAttrs.addFlashAttribute("userRegistrationForm", form);
            redirAttrs.addFlashAttribute("errorMsg", REGISTRATION_ERROR);

            return false;
        }

        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();
        if (!password.equals(confirmPassword)) {
            bindingResult.rejectValue("confirmPassword", "userRegistrationForm.password", CONFIRM_PASSWORD_NOT_MATCH);
            redirAttrs.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationForm", bindingResult);
            redirAttrs.addFlashAttribute("userRegistrationForm", form);
            redirAttrs.addFlashAttribute("errorMsg", REGISTRATION_ERROR);

            return false;
        }

        if (appUserService.existsByUsername(form.getUsername())) {
            bindingResult.rejectValue("username", "userRegistrationForm.password", ACCOUNT_EXISTED);
            redirAttrs.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationForm", bindingResult);
            redirAttrs.addFlashAttribute("userRegistrationForm", form);
            redirAttrs.addFlashAttribute("errorMsg", REGISTRATION_ERROR);

            return false;
        }

        return true;
    }

}
