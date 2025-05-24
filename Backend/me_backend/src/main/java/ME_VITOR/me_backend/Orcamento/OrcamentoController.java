package ME_VITOR.me_backend.Orcamento;


import ME_VITOR.me_backend.Email.EmailService;
import ME_VITOR.me_backend.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/orcamentos")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class OrcamentoController {

    @Autowired
    private EmailService emailService;

    private final OrcamentoService orcamentoService;

    public OrcamentoController(OrcamentoService orcamentoService) {
        this.orcamentoService = orcamentoService;
    }


    @PostMapping("/solicitar")
    public void solicitarOrcamento(@RequestBody OrcamentoModel orcamentodetalhes){
        String projetoDescricao = orcamentodetalhes.getProjetoDescricao();
       LocalDate dataInicio = orcamentodetalhes.getDataInicio();
        byte[] projetoDesenho = orcamentodetalhes.getProjetoDesenho();
        orcamentoService.processarOrcamento(projetoDescricao,dataInicio,projetoDesenho);


    }
}
