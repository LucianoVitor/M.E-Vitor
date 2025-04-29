package ME_VITOR.me_backend.User;


import ME_VITOR.me_backend.DTO.LoginRequest;
import ME_VITOR.me_backend.Token.ResetPasswordRequest;
import org.eclipse.angus.mail.imap.protocol.Status;
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




    @PatchMapping("/reset/request")
    public ResponseEntity<String> requestmodifyPass(@RequestBody UserModel user){

         userService.RequestchangePassword(user);
         return ResponseEntity.ok("Sla pô");
    }


    @PatchMapping("/reset/confirm")
    public void changePassword(@RequestBody ResetPasswordRequest resetRequest){

        userService.ChangePassword(resetRequest);
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
