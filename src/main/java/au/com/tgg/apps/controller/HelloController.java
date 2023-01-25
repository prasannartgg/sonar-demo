package au.com.tgg.apps.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class HelloController {

    @GetMapping("/greeter")
    public String greet() {
        return "This is a message from the demo app for Sonarqube";
    }
}
