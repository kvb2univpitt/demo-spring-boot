package com.github.kvb2univpitt.demo.secured.webapp.ctrl;

import com.github.kvb2univpitt.demo.secured.webapp.HttpError;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * Dec 27, 2020 1:04:44 AM
 *
 * @author Kevin V. Bui (kvb2univpitt@gmail.com)
 */
@Controller
public class ApplicationErrorController implements ErrorController {

    private final HttpError BAD_REQ = new HttpError(HttpStatus.BAD_REQUEST.value(), "Bad Request", "Sorry, bad request.");
    private final HttpError UNAUTH_ACCESS = new HttpError(HttpStatus.UNAUTHORIZED.value(), "Unauthorized Access", "Sorry, you need to sign in to view this page.");
    private final HttpError PAGE_NOT_FOUND = new HttpError(HttpStatus.NOT_FOUND.value(), "Page Not Found", "Sorry, but the page you were trying to view does not exist.");
    private final HttpError INTERNAL_SERV_ERR = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", "Sorry, we are currently experiencing an internal issue.");

    @GetMapping("/error")
    public String showErrorPage(final HttpServletRequest req, final Model model) {
        Object status = req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        model.addAttribute("error", getError(status));

        return "error";
    }

    private HttpError getError(Object status) {
        if (status == null) {
            return INTERNAL_SERV_ERR;
        }

        switch (Integer.valueOf(status.toString())) {
            case 400:
                return BAD_REQ;
            case 401:
                return UNAUTH_ACCESS;
            case 404:
                return PAGE_NOT_FOUND;
            case 405:
                return PAGE_NOT_FOUND;
            default:
                return INTERNAL_SERV_ERR;
        }
    }

    @Override
    public String getErrorPath() {
        return null;
    }

}
