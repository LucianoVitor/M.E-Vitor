package ME_VITOR.me_backend.Visita;

import ME_VITOR.me_backend.User.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VisitaModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private LocalDate data;

        private LocalTime horario;

        @ManyToOne
        @JoinColumn(name = "usuario_id")
        private UserModel usuario;


    }

