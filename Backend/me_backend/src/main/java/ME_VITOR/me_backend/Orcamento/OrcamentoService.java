package ME_VITOR.me_backend.Orcamento;

import ME_VITOR.me_backend.Email.EmailService;
import ME_VITOR.me_backend.User.UserModel;
import ME_VITOR.me_backend.User.UserRepository;
import ME_VITOR.me_backend.Util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class OrcamentoService {

    @Autowired
    private EmailService emailService;

    @Autowired
    private HttpServletRequest request;

    private final OrcamentoRepository orcamentoRepository;
    private final UserRepository userRepository;


    public OrcamentoService(OrcamentoRepository orcamentoRepository, UserRepository userRepository) {
        this.orcamentoRepository = orcamentoRepository;
        this.userRepository = userRepository;}


    public void processarOrcamento(String projetoDescricao, LocalDate dataInicio, byte[] projetoDesenho){
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<UserModel> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()){
            UserModel user = userOptional.get();
            OrcamentoModel orcamento = new OrcamentoModel();
            orcamento.setUsuario(user);
            orcamento.setDataInicio(dataInicio);
            orcamento.setProjetoDescricao(projetoDescricao);
            orcamento.setProjetoDesenho(projetoDesenho);
            orcamentoRepository.save(orcamento);
            System.out.println("sucesso");
            //emailService.enviarEmail(email,"Solicitação de Orçamento Realizada", "Verifique a descrição enviada: \n"+"Data para ínicio:"+dataInicio+"\nDescrição do Projeto: "+projetoDescricao+"\nRetornaremos com uma resposta em breve, fique atento ao seu email e telefone.");
        } else throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

    }


    }

