package com.github.kvb2univpitt.demo.secured.webapp.ctrl;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 *
 * Dec 31, 2020 3:23:05 PM
 *
 * @author Kevin V. Bui (kvb2univpitt@gmail.com)
 */
@ControllerAdvice
@Controller
public class WebDataBinderInitializer {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

}
