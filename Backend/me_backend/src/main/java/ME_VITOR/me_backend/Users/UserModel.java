package ME_VITOR.me_backend.Users;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserModel {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;

 private String name;

 @Column(unique = true)
 private String email;

 private String password;

}
