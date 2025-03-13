  package ME_VITOR.me_backend.User;


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
   Integer id;
   String name;
   @Column(unique = true)
   String email;
   String telefone;
   private String password;

  }
