package com.Pijamoon.pijamoon_backend.mapper;

import com.Pijamoon.pijamoon_backend.dto.UserDTO;
import com.Pijamoon.pijamoon_backend.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserModel map(UserDTO userDTO) {
        UserModel userModel = new UserModel();
        userModel.setId(userDTO.getId());
        userModel.setCpf(userDTO.getCpf());
        userModel.setEmail(userDTO.getEmail());
        userModel.setNome(userDTO.getNome());
        userModel.setTelefone(userDTO.getTelefone());

        return userModel;
    }

    public UserDTO map(UserModel userModel) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userModel.getId());
        userDTO.setCpf(userModel.getCpf());
        userDTO.setEmail(userModel.getEmail());
        userDTO.setNome(userModel.getNome());
        userDTO.setTelefone(userModel.getTelefone());

        return userDTO;
    }
}
