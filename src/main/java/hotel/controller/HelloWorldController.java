package hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
    @ResponseBody
    @RequestMapping("/test")
    public String helloworld() {
        return "Hello, World!";
    }

    @ResponseBody
    @RequestMapping("/hyu")
    public String hyu() {
        return "Hello, Hyu!";
    }

}

