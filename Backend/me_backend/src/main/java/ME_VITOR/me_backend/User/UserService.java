package ME_VITOR.me_backend.User;


import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Mostrar Usuários
    public List<UserModel> showUsers(){

        return userRepository.findAll();
    }


    //Cadastra usuário
    public UserModel CreateUser(UserModel user){
        return userRepository.save(user);
    }


}
