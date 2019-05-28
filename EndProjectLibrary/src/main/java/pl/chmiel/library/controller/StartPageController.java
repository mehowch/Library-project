package pl.chmiel.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class StartPageController {

  @GetMapping("/startpage")
  private String index(Principal principal) {
    return "startpage";
  }
}
