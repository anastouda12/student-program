package g43256.webg5.pae.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
/**
 * SecurityController
 */
public class SecurityController {

    @GetMapping("/login")
    public String home() {
        return "login";
    }

}