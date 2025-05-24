package ME_VITOR.me_backend.Orcamento;

import ME_VITOR.me_backend.User.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrcamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] projetoDesenho;

    private LocalDate dataInicio;

    @Column(length = 2048, name ="Descricao_Projeto")
    private String projetoDescricao;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private UserModel usuario;
}

