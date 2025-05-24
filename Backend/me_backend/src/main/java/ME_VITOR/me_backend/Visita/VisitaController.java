package ME_VITOR.me_backend.Visita;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/visitas")
@CrossOrigin(origins = "*")
public class VisitaController {

    private final VisitaService visitaService;

    public VisitaController(VisitaService visitaService) {
        this.visitaService = visitaService;
    }


    @PostMapping("/agendar")
    public void agendarVisita(@RequestBody AgendamentoRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        visitaService.agendarVisita(request.getData(), request.getHorario(), email);
    }
}
@AllArgsConstructor
@NoArgsConstructor
@Data
class AgendamentoRequest {
    private LocalDate data;
    private LocalTime horario;

}
