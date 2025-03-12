package ME_VITOR.me_backend;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="tb_cadastro")
public class UserModel {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 int id;
 String name;
 @Column(unique = true)
 String email;
 String Telefone;
 private String password;

}
