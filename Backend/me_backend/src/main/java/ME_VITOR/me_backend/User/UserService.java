package ME_VITOR.me_backend.User;



import ME_VITOR.me_backend.Email.EmailService;
import ME_VITOR.me_backend.Token.ResetPasswordRequest;
import ME_VITOR.me_backend.Token.TokenModel;
import ME_VITOR.me_backend.Token.TokenRepository;
import ME_VITOR.me_backend.Token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private TokenRepository tokenRepository;


    @Autowired
    private EmailService emailService;
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
        if (user.getPassword().length() > 72) {
            throw new IllegalArgumentException("Senha Muito Longa");
        }
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



        public void RequestchangePassword(UserModel user){
            Optional<UserModel> userOptional = userRepository.findByEmail(user.getEmail());
            TokenModel verificador = new TokenModel();
            if (userOptional.isPresent()) {
                UserModel existingUser =userOptional.get();
                Optional<TokenModel> tokenOptional = tokenRepository.findByUsuario_id(existingUser.getId());

                if (tokenOptional.isPresent()) {
                    TokenModel verificadorDB = new TokenModel();
                    verificadorDB = tokenOptional.get();
                    emailService.enviarEmail(existingUser.getEmail(), "Redefinição de Senha -Token M.E Vitor", "Redefinição de senha solicitada! \n copie e cole o código a seguir: "+ verificadorDB.getUuid()+ "\n Caso não tenha Solicitado Ignore este E-mail");
                }else {
                    verificador.setUsuario(existingUser);
                    verificador.setUuid(UUID.randomUUID().toString());
                    verificador.setExpiracao(Instant.now().plusMillis(900000));
                    tokenRepository.save(verificador);
                    emailService.enviarEmail(existingUser.getEmail(), "Redefinição de Senha -Token M.E Vitor", "Redefinição de senha solicitada! \n copie e cole o código a seguir: " + verificador.getUuid() + "\n Caso não tenha Solicitado Ignore este E-mail");
                }
        }
            else
                throw new RuntimeException("Nenhum usuário foi encontrado com esse email");
    }

public UserModel ChangePassword(ResetPasswordRequest valuesRequest){
    TokenModel verificador = new TokenModel();
    TokenModel verificadorDB = new TokenModel();
    Optional<UserModel> userOptional = userRepository.findByEmail(valuesRequest.getEmail());
    if (userOptional.isPresent()) {
        verificador.setUuid(valuesRequest.getToken());
        UserModel existingUser = userOptional.get();
        Optional<TokenModel> tokenOptional = tokenRepository.findByUsuario_id(existingUser.getId());
        if (tokenOptional.isPresent()) {
            verificadorDB = tokenOptional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nenhum usuário foi encontrado com esse email");
        }
        if (verificador.getUuid().equals(verificadorDB.getUuid())) {
            String toEncode = valuesRequest.getPassword();
            existingUser.setPassword(passwordEncoder.encode(toEncode));
            return userRepository.save(existingUser);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Token Inválido");

    }
    else
        throw new RuntimeException("Nenhum usuário foi encontrado com esse email");
}


}

