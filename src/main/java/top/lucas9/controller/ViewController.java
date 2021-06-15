package top.lucas9.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.lucas9.utils.AuthenticateUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author lucas
 */
@Controller
@RequestMapping("/to")
public class ViewController {
    @RequestMapping("/index")
    public String toIndex() {
        return "index";
    }

    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }
}
