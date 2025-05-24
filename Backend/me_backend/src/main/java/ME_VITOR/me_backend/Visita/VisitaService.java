package ME_VITOR.me_backend.Visita;

import ME_VITOR.me_backend.User.UserModel;
import ME_VITOR.me_backend.User.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class VisitaService {

    private final VisitaRepository visitaRepository;
    private final UserRepository userRepository;

    public VisitaService(VisitaRepository visitaRepository, UserRepository userRepository) {
        this.visitaRepository = visitaRepository;
        this.userRepository = userRepository;
    }

    public void agendarVisita(LocalDate data, LocalTime horario, String email) {

        if (data.getDayOfWeek() == DayOfWeek.SUNDAY) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Domingo não é permitido para agendamento");
        }

        if (visitaRepository.existsByDataAndHorario(data, horario)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Horário já agendado");
        }

        UserModel user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuário não encontrado"));

        VisitaModel visita = new VisitaModel();
        visita.setData(data);
        visita.setHorario(horario);
        visita.setUsuario(user);
        visitaRepository.save(visita);
    }
}
