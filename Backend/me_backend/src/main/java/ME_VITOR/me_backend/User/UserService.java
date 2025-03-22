package ME_VITOR.me_backend.User;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder= new BCryptPasswordEncoder();
    }

    //Mostrar Usuários
    public List<UserModel> showUsers(){
        return userRepository.findAll();
    }


    //Cadastra usuário
    public UserModel CreateUser(UserModel user){
        String toEncode = user.getPassword();
        user.setPassword(passwordEncoder.encode(toEncode));
        return userRepository.save(user);
    }
public boolean login(String email, String password) {
    Optional<UserModel> userOptional = userRepository.findByEmail(email);
    if (userOptional.isPresent()) {
        UserModel user = userOptional.get();
        return passwordEncoder.matches(password, user.getPassword());
    }
    return false;}
}

