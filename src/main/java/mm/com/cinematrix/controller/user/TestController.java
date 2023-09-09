package mm.com.cinematrix.controller.user;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("ab")
    public String test(){
        return "ab";
    }
}
