package ME_VITOR.me_backend;


import jakarta.persistence.*;

@Entity
@Table(name ="tb_cadastro")
public class UserModel {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 int id;
 String name;
 String email;
 private String password;

 UserModel(String name, String email, String password){
     this.name = name;
     this.email = email;
     this.password = password;
 }

    public UserModel() {
    }

    public String getName(){
        return this.name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
