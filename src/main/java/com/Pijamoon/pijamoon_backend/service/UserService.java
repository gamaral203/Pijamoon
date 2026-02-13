package com.Pijamoon.pijamoon_backend.service;

import com.Pijamoon.pijamoon_backend.model.UserModel;
import com.Pijamoon.pijamoon_backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    //Injeção de dependência
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Salvar Usuario no banco de dados
    public UserModel salvar(UserModel user) {
        return userRepository.save(user);
    }


    //Buscar por ID
    public UserModel listarPorId(Long id) {
        Optional<UserModel> user = userRepository.findById(id);
        return user.orElse(null);
    }

}
