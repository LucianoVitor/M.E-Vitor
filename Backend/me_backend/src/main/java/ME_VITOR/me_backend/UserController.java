package ME_VITOR.me_backend;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {

UserModel newUser = new UserModel();

    @GetMapping("/user")
    public String getName(){
       return "";
    }


}
