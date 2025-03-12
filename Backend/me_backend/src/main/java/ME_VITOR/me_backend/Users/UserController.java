package ME_VITOR.me_backend.Users;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {
    UserModel user = new UserModel();

    @GetMapping("/user")
    public String HelloWorld(){
       return "Hello World";
    }


}
