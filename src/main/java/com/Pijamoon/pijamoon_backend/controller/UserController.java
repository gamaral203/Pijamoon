package com.Pijamoon.pijamoon_backend.controller;

import com.Pijamoon.pijamoon_backend.dto.UserDTO;
import com.Pijamoon.pijamoon_backend.model.UserModel;
import com.Pijamoon.pijamoon_backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Criar usuario
    @PostMapping("/criar")
    public UserDTO criarUsuario(@RequestBody UserDTO user) {
        return userService.salvar(user);
    }

    //Edita usuario
    @PutMapping("/editarcomID")
    public String editarUsuarioId() {
        return "Editado";
    }

    //Buscar por ID
    @GetMapping("/buscarPorID{id}")
    public UserDTO listarPorId(@PathVariable Long id) {
        return userService.listarPorId(id);
    }

    //Listar Todos
    @GetMapping("/listar")
    public List<UserModel> listar() {
        return userService.listarusuarios();

    }

    //Deletar usuario
    @DeleteMapping("/deletar/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        userService.deletarPorId(id);
    }

}


