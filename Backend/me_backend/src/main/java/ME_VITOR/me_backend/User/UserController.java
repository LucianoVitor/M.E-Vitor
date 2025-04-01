package ME_VITOR.me_backend.User;


import ME_VITOR.me_backend.DTO.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UserController {

    private final UserService userService;

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

    @PatchMapping("/change_password")
    public  UserModel modifyPass(@RequestBody UserModel user){

        return userService.changePassword(user);
    }

    @PostMapping("/auth")
   public ResponseEntity<String> login (@RequestBody LoginRequest request){
        boolean isAuthenticated = userService.login(request.getEmail(), request.getPassword());

        if (isAuthenticated){
            return ResponseEntity.ok("Login Realizado com Sucesso");
        }else {
            return ResponseEntity.status(401).body("Email ou Senha Inválida");
        }
    }

}
