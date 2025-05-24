package ME_VITOR.me_backend.Visita;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface VisitaRepository extends JpaRepository<VisitaModel, Long> {
        List<VisitaModel> findByData(LocalDate data);

        boolean existsByDataAndHorario(LocalDate data, LocalTime horario);
    }

