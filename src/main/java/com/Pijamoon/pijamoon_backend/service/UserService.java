package com.Pijamoon.pijamoon_backend.service;

import com.Pijamoon.pijamoon_backend.dto.UserDTO;
import com.Pijamoon.pijamoon_backend.mapper.ProdutoMapper;
import com.Pijamoon.pijamoon_backend.mapper.UserMapper;
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
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    //Salvar Usuario no banco de dados
    public UserDTO salvar(UserDTO userDTO) {
        UserModel user = userMapper.map(userDTO);
        user = userRepository.save(user);
        return userMapper.map(user);
    }


    //Buscar por ID
    public UserDTO listarPorId(Long id) {
        Optional<UserModel> userPorId = userRepository.findById(id);
        return userPorId.map(userMapper::map).orElse(null);    }

    //Lista todos os usuarios
    public List<UserModel> listarusuarios() {
        return userRepository.findAll();
    }

    //Deletar usuario -- tem que ser void pois não precisa retornar nada pro usuário
    public void deletarPorId(Long id) {
        userRepository.deleteById(id);
    }
}
