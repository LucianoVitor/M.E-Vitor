package ME_VITOR.me_backend.User;


import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private UserMapper userMapper;
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
