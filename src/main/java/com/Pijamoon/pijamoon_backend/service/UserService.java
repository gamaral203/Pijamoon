package com.Pijamoon.pijamoon_backend.service;

import com.Pijamoon.pijamoon_backend.model.UserModel;
import com.Pijamoon.pijamoon_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

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

}
