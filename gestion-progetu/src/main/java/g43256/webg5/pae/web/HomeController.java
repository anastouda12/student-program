package g43256.webg5.pae.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

/**
 * HomeController
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String showIndex(Model model) {
        return "home";
    }
}
