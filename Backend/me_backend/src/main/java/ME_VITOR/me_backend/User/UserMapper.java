package ME_VITOR.me_backend.User;

public class UserMapper {
public UserModel map(UserDTO userDTO){
    UserModel userModel = new UserModel();
    userModel.setId(userDTO.getId());
    userModel.setName(userDTO.getName());
    userModel.setEmail(userDTO.getEmail());
    userModel.setTelefone(userDTO.getTelefone());
    userModel.setPassword(userDTO.getPassword());
return userModel;
}


public UserDTO map(UserModel userModel){
    UserDTO userDTO = new UserDTO();
    userDTO.setId(userModel.getId());
    userDTO.setName(userModel.getName());
    userDTO.setEmail(userModel.getEmail());
    userDTO.setTelefone(userModel.getTelefone());
    userDTO.setPassword(userModel.getPassword());
return userDTO;
}

}
