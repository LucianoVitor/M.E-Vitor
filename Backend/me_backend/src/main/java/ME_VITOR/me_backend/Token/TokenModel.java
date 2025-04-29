package ME_VITOR.me_backend.Token;


import ME_VITOR.me_backend.User.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.Instant;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="Token_Model")
public class TokenModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "CHAR(36)", unique = true)
    private String uuid;

    @Column(nullable = false)
    private Instant expiracao;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", unique = true)
    private UserModel usuario;

    }






