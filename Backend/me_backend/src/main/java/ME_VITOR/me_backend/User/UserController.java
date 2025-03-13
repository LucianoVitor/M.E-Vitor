package ME_VITOR.me_backend.User;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/showUser")
    public List<UserModel> showUsers(){
       return userService.showUsers();

    }

    @PostMapping("/create")
    public UserModel createUser(@RequestBody UserModel user){
        return  userService.CreateUser(user);
    }

    @PutMapping("/modify_user")
    public String modifyUser(){
        return "Dados modificados";
    }




}
